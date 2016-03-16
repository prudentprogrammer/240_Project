private Runnable mResumeRunnable = new Runnable() {
        @Override
        public void run() {
            if (handler == null) {
                return;
            }
            mResumeTryCount++;
            if (mResumeTryCount > 4 || DanmakuView.super.isShown()) {
                handler.resume();
            } else {
                handler.postDelayed(this, 100 * mResumeTryCount);
            }
        }
    };