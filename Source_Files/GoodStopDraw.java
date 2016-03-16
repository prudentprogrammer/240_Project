private void stopDraw() {
        DrawHandler handler = this.handler;
        this.handler = null;
        unlockCanvasAndPost();
        if (handler != null) {
            handler.quit();
        }
        if (mHandlerThread != null) {
            HandlerThread handlerThread = this.mHandlerThread;
            mHandlerThread = null;
            try {
                handlerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }