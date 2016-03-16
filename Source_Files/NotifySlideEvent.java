protected void notifySlideEvent(float yPosition) {
    super.notifySlideEvent(yPosition);
    if (hY <= sSThreshold && yPosition >= sSThreshold) {
        //down
        if (sS != STATE_HIDDEN)
            sS = STATE_COLLAPSED;
        if (oSCL != null) {
            oSCL.onStateChanged(getPage(mPager.getCurrentItem()), sS);
        }
    } else if (hY >= sSThreshold && yPosition < sSThreshold) {
        //up
        sS = STATE_EXPANDED;
        if (oSCL != null) {
            oSCL.onStateChanged(getPage(mPager.getCurrentItem()), sS);
        }
    }
    hY = yPosition;
}