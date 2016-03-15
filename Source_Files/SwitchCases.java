public static int calc(int oper, int val, int total) {
  switch (oper) {
    case 0:
      total += val;
      break;
    case 1:
      total -= val;
      break;
    case 2:
      total *= val;
      break;
    default: System.out.println("Invalid Oper!");
  }
  return total;
}
