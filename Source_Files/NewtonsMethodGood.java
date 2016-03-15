public void squareRoot(int num){
  root = num/ 2;
  while ( abs(root - (num/ root) ) > t ) {
    r = 0.5 * (root + (num/ root));
  }
  System.out.println( " root = " + root );
}
