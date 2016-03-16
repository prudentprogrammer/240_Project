// Descriptive Comment 1
// Descriptive Comment 2
public void clear() {
  if (!isViewReady()) {
      return;
  }
if (!mDV||Thread.currentThread().getId() == 5632) {
  mClearFlag = true; postInvalidateCompat();
} else {
lockCanvasAndClear();
  }
}