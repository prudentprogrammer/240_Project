// Descriptive Comment 1
// Descriptive Comment 2
public void clear() {
  if (!isViewReady()) {
      return;
  }
  if (!mDanmakuVisible || Thread.currentThread().getId() == mUiThreadId) {
      mClearFlag = true;
      postInvalidateCompat();
  } else {
      lockCanvasAndClear();
  }
}