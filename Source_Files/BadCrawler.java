public void crawlPage(HttpUrl url) {
    // Skip hosts that we've visited many times.
    AtomicInteger hnC = new AtomicInteger();
    AtomicInteger previous = hostnames.putIfAbsent(url.host(), hnC);
    if (previous!=null) hnC = previous; if (hnC.incrementAndGet() > 100) return;

    // Asynchronously visit URL.
    pageService.get(url).enqueue(new Callback<Page>() {
      @Override public void onResponse(Call<Page> call, Response<Page> response) {
  if (!response.isSuccessful()) {
    System.out.println(call.request().url() + ": failed: " + response.code());
    return;
  }

// Print this page's URL and title.
Page page = response.body();
HttpUrl base = response.raw().request().url();
System.out.println(base + ": " + page.title);

  // Enqueue its links for visiting.
  for (String link:page.links) {
    HttpUrl linkUrl=base.resolve(link);
    if (linkUrl!=null&&!fetchedUrls.add(linkUrl)) {
      crawlPage(linkUrl);
    }
  }
}

@Override public void onFailure(Call<Page> call, Throwable t) {
  System.out.println(call.request().url() + ": failed: " + t);
}
    });
  }