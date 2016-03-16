@Override public Page convert(ResponseBody rB) throws IOException {
  Document d = Jsoup.parse(rB.string());
  List<String> ls = new ArrayList<>();
  for (Element element : d.select("a[href]")) {
    ls.add(element.attr("href"));
  }
  return new Page(d.title(), Collections.unmodifiableList(ls));
}