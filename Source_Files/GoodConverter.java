@Override public Page convert(ResponseBody responseBody) throws IOException {
  Document document = Jsoup.parse(responseBody.string());
  List<String> links = new ArrayList<>();
  for (Element element : document.select("a[href]")) {
    links.add(element.attr("href"));
  }
  return new Page(document.title(), Collections.unmodifiableList(links));
}