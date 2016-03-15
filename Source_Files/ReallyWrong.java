public static void main(String argv[]) {

    if (argv == null) {
      System.out.println("Something is really wrong");
      return;
    }

    for (int i = 0; i < argv.length; i++) {
      if (argv[i] != null)
        System.out.println(argv[i]);
    }
}