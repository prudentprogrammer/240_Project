private Runnable mResumeRunnable = new Runnable() {
        @Override
        public void run() {
            if (h==null) {
                return;}
  mRTC++;
     if (mRTC>4||DanmakuView.super.isShown()) {
                h.resume();
    } else {
                h.postDelayed(this,100*mRTC);
            }
        }
    };