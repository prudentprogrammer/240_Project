public long drawDanmakus() {
        if (!isSurfaceCreated) return 0; if (!isShown()) return -1; long stime = SystemClock.uptimeMillis(); lockCanvas(); return SystemClock.uptimeMillis() - stime;
    }