  /**
     * Start the node. If the node is already started, this method is no-op.
     */
    public Node start() {
        if (!lifecycle.moveToStarted()) {
            return this;
        }

        ESLogger logger = Loggers.getLogger(Node.class, NODE_NAME_SETTING.get(settings));
        logger.info("starting ...");
        // hack around dependency injection problem (for now...)
        injector.getInstance(Discovery.class).setRoutingService(injector.getInstance(RoutingService.class));
        for (Class<? extends LifecycleComponent> plugin : pluginsService.nodeServices()) {
            injector.getInstance(plugin).start();
        }

        injector.getInstance(MappingUpdatedAction.class).setClient(client);
        injector.getInstance(IndicesService.class).start();
        injector.getInstance(IndicesClusterStateService.class).start();
        injector.getInstance(IndicesTTLService.class).start();
        injector.getInstance(SnapshotsService.class).start();
        injector.getInstance(SnapshotShardsService.class).start();
        injector.getInstance(RoutingService.class).start();
        injector.getInstance(SearchService.class).start();
        injector.getInstance(MonitorService.class).start();
        injector.getInstance(RestController.class).start();

        assert injector.getInstance(ClusterService.class) instanceof InternalClusterService :
                "node cluster service implementation must inherit from InternalClusterService";
        final InternalClusterService clusterService = (InternalClusterService) injector.getInstance(ClusterService.class);

        final NodeConnectionsService nodeConnectionsService = injector.getInstance(NodeConnectionsService.class);
        nodeConnectionsService.start();
        clusterService.setNodeConnectionsService(nodeConnectionsService);

        // TODO hack around circular dependencies problems
        injector.getInstance(GatewayAllocator.class).setReallocation(clusterService, injector.getInstance(RoutingService.class));

        injector.getInstance(ResourceWatcherService.class).start();
        injector.getInstance(GatewayService.class).start();
        Discovery discovery = injector.getInstance(Discovery.class);
        clusterService.addInitialStateBlock(discovery.getDiscoverySettings().getNoMasterBlock());
        clusterService.setClusterStatePublisher(discovery::publish);

        // start before the cluster service since it adds/removes initial Cluster state blocks
        final TribeService tribeService = injector.getInstance(TribeService.class);
        tribeService.start();


        // Start the transport service now so the publish address will be added to the local disco node in ClusterService
        TransportService transportService = injector.getInstance(TransportService.class);
        transportService.start();
        DiscoveryNode localNode = injector.getInstance(DiscoveryNodeService.class)
                .buildLocalNode(transportService.boundAddress().publishAddress());

        // TODO: need to find a cleaner way to start/construct a service with some initial parameters,
        // playing nice with the life cycle interfaces
        clusterService.setLocalNode(localNode);
        transportService.setLocalNode(localNode);
        clusterService.add(transportService.getTaskManager());

        clusterService.start();

        // start after cluster service so the local disco is known
        discovery.start();
        transportService.acceptIncomingRequests();
        discovery.startInitialJoin();
        // tribe nodes don't have a master so we shouldn't register an observer
        if (DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.get(settings).millis() > 0) {
            final ThreadPool thread = injector.getInstance(ThreadPool.class);
            ClusterStateObserver observer = new ClusterStateObserver(clusterService, null, logger, thread.getThreadContext());
            if (observer.observedState().nodes().masterNodeId() == null) {
                final CountDownLatch latch = new CountDownLatch(1);
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
                    @Override
                    public void onNewClusterState(ClusterState state) { latch.countDown(); }

                    @Override
                    public void onClusterServiceClose() {
                        latch.countDown();
                    }

                    @Override
                    public void onTimeout(TimeValue timeout) {
                        logger.warn("timed out while waiting for initial discovery state - timeout: {}",
                            DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.get(settings));
                        latch.countDown();
                    }
                }, MasterNodeChangePredicate.INSTANCE, DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.get(settings));

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new ElasticsearchTimeoutException("Interrupted while waiting for initial discovery state");
                }
            }
        }

        if (settings.getAsBoolean("http.enabled", true)) {
            injector.getInstance(HttpServer.class).start();
        }

        // start nodes now, after the http server, because it may take some time
        tribeService.startNodes();


        if (WRITE_PORTS_FIELD_SETTING.get(settings)) {
            if (settings.getAsBoolean("http.enabled", true)) {
                HttpServerTransport http = injector.getInstance(HttpServerTransport.class);
                writePortsFile("http", http.boundAddress());
            }
            TransportService transport = injector.getInstance(TransportService.class);
            writePortsFile("transport", transport.boundAddress());
        }

        logger.info("started");

        return this;
    }