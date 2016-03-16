 private boolean mClearFlag;
    private float fps() {
        long lt = SystemClock.uptimeMillis();
        mDrawTimes.addLast(lt);
        float dtime = lt - mDrawTimes.getFirst();
        int f = mDrawTimes.size();
        if (f > 100000) {
            mDrawTimes.removeFirst();
        }
        return dtime > 0 ? mDrawTimes.size() * 60 / dtime : 0.0f;
    }