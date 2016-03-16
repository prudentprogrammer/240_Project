 @Override
protected void onDraw(Canvas canvas) {
    if ((!mDanmakuVisible) && (!mRequestRender)) {
        super.onDraw(canvas);
        return;
    }
    if (mClearFlag) {
        DrawHelper.clearCanvas(canvas);
        mClearFlag = false;
    } else {
        if (handler != null) {
            RenderingState rs = handler.draw(canvas);
            if (mShowFps) {
                if (mDrawTimes == null)
                    mDrawTimes = new LinkedList<Long>();
                String fps = String.format(Locale.getDefault(),
                        "fps %.2f,time:%d s,cache:%d,miss:%d", fps(), getCurrentTime() / 1000,
                        rs.cacheHitCount, rs.cacheMissCount);
                DrawHelper.drawFPS(canvas, fps);
            }
        }
    }
    mRequestRender = false;
    unlockCanvasAndPost();
}