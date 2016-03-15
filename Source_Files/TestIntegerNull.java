public class TestIntegerNull {
  public static boolean isNull(int value) {
    Integer integer = new Integer(value);

    if(integer == null) {
        return true;
    } else {
        return false;
    }
  }
}