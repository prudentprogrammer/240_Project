public static void main (String args[]) {
  x i;
  try {
    try {
      i = new x();
      i.foo();
    } catch (x exc) {
      System.out.println("inner exc");
      if (exc.eventime == 0)
        throw exc;
      }
  } catch (x exc1) {
    System.out.println("outer exc");
  }
}