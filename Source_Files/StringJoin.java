public class StringJoin {

  public static void main(String[] args) {
    StringUtils.join(
      Arrays.asList(
        "first line",
        "second line",
        StringUtils.join(
          Arrays.asList("a", "b")
        )
      ),
      "separator"
    );
   }

}