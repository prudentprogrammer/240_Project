public static void main(String... args) throws Exception {
  Dispatcher dispatcher = new Dispatcher(Executors.newFixedThreadPool(20));
  dispatcher.setMaxRequests(20);
  dispatcher.setMaxRequestsPerHost(1);

  OkHttpClient okHttpClient = new OkHttpClient.Builder().dispatcher(dispatcher).connectionPool(new ConnectionPool(100, 30, TimeUnit.SECONDS)).build();

  Retrofit retrofit = new Retrofit.Builder().baseUrl(HttpUrl.parse("https://example.com/")).addConverterFactory(PageAdapter.FACTORY).client(okHttpClient).build();

  PageService pageService = retrofit.create(PageService.class);

  Crawler crawler = new Crawler(pageService);
  crawler.crawlPage(HttpUrl.parse(args[0]));
}