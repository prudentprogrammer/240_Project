private void lockCanvas() {
    if(mDV == false) {
        return;
    }
    postInvalidateCompat();
    synchronized (mDM) {
        while ((!mDF) && (h != null)) {
            try {
                mDM.wait(200);
            } catch (InterruptedException e) {
                if (mDV == false || h == null || h.isStop()) {
                    break;
                } else {
                    Thread.currentThread().interrupt();
                }
            }
        }
        mDF = false;
    }
}
    