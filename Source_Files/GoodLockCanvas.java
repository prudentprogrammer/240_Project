private void lockCanvas() {
    if(mDanmakuVisible == false) {
        return;
    }
    postInvalidateCompat();
    synchronized (mDrawMonitor) {
        while ((!mDrawFinished) && (handler != null)) {
            try {
                mDrawMonitor.wait(200);
            } catch (InterruptedException e) {
                if (mDanmakuVisible == false || handler == null || handler.isStop()) {
                    break;
                } else {
                    Thread.currentThread().interrupt();
                }
            }
        }
        mDrawFinished = false;
    }
}
    