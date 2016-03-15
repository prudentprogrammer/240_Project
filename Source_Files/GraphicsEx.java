void ___(Graphics  r1, float  f0, float  f1, float  f2, float  f3, float  f4, int  i0) {
  lII = f0; 
  lll = f1; 
  lIl = f3;
  lIII();
  float f6 = lII;
  float f5 = lll;
  int i3 = i0 + -1;

  if (i3 >= 3) {
    r1.setColor(Color.white);
    ___(r1, f2, (int)f0, ll1 - (int)f1, (int)f6, ll1 - (int)f5);
  } else {
    r1.setColor(Color.green);
    ___(r1, f2, (int)f0, ll1 - (int)f1, (int)f6, ll1 - (int)f5);
  }

  if (i3 > 0) {
    $5$ = this.____(f0, f1, f6, f5);
    l11I(Ill1);
    _____(r1, lII, lll, $5S * f2, Il1 * f3, Ill1, i3);
    $5$ = ____(f0, f1, f6, f5);
    l11I((- (SSS)));
    _____(r1, f6, f5, $5S * f2, Il1 * f3, SSS, i3);
  }
}
