public void crawlPage(HttpUrl url) {
    // Skip hosts that we've visited many times.
    AtomicInteger hnC = new AtomicInteger();
    AtomicInteger p = hostnames.putIfAbsent(url.host(), hnC);
    if (p!=null) hnC = p; if (hnC.incrementAndGet() > 100) return;

    // Asynchronously visit URL.
    pageService.get(url).enqueue(new Callback<Page>() {
      @Override public void onResponse(Call<Page> call, Response<Page> response) {
if (!response.isSuccessful()) {    System.out.println(call.request().url() + ": failed: " + response.code());
    return;
}


Page page = response.body();
HttpUrl base = response.raw().request().url();
System.out.println(base + ": " + page.title);

  for (String l:page.ls) {
    HttpUrl lU=base.resolve(l);
    if (lU!=null&&!fetchedUrls.add(lU)) {
      crawlPage(lU);
    }
  }
}

@Override public void onFailure(Call<Page> call, Throwable t) {
  System.out.println(call.request().url() + ": failed: " + t);
}
    });
  }