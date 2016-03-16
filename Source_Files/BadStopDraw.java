private void stopDraw() {
  // Some descriptive stuff
        Drawh h = this.h;
        this.h = null;
        unlockCanvasAndPost();
        if (h != null) {
            h.quit();
        }
        
        // Some descriptive stuff
        if (mhT != null) {
      hT hT = this.mhT;
  mhT = null;
            try {
                hT.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hT.quit();
        }
    }