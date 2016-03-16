public static void main(String... args) throws Exception {
  d d = new d(Executors.newFixedThreadPool(20));
  d.setMaxRequests(20);
  d.setMaxRequestsPerHost(1);

  oHC oHC = new oHC.Builder().d(d).connectionPool(new ConnectionPool(100, 30, TimeUnit.SECONDS)).build();

  rf rf = new rf.Builder().baseUrl(HttpUrl.parse("https://example.com/")).addConverterFactory(PageAdapter.FACTORY).client(oHC).build();

  pS pS = rf.create(pS.class);

  c c = new c(pS);
  c.crawlPage(HttpUrl.parse(args[0]));
}