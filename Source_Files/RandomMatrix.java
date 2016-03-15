private static double[][] RandomMatrix(int M, int N, Random R) {
  double A[][] = new double[M][N];

  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      A[i][j] = R.nextDouble();

  return A;
}