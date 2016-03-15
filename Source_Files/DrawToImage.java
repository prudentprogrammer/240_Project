public static void main(String args[]) {
  int level = 23;

  if (args.length > 1 && args[1] != null 
      && args[1].equalsIgnoreCase("-i"))
    drawToImage = true;

  if (args.length > 0) {
    String arg = args[0];

    if (arg == null || arg.toLowerCase().indexOf("help") >= 0) {
      printHelp();
      System.exit(1);
    } else {
      try {
        level = Integer.parseInt(arg);
      } catch (NumberFormatException exc) {
        System.out.println("Illegal Depth Number!");
        System.exit(1);
      }
    }
  } else {
    drawToImage = true;
  }
  setLevel(level);
  new Fractal();
}