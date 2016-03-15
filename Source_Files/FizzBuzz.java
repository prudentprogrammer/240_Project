for (int i=1;i<=100;i++) {
      int a=((528>>i%15-1)&1)*4;
      int b=((-2128340926>>(i%15)*2)&3)*4;
      System.out.println("FizzBuzz".substring(a,b)+(a==b?i:""));
}
