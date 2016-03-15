static void FillPowerMatrix(Digit matrix[][], Digit x[]) {
  int n = matrix[0].length;

  for (int i = 0; i < n; i++) {
    matrix[i][0] = new Digit(1);

    for (int j = 1; j < n; j++) {
      matrix[i][j] = matrix[i][j-1].mult(x[i]);
    }
  }
}