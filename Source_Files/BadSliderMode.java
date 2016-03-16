private void setsM(@sM byte m) {
        switch (m) {
            case m_REGULAR: // full screen
                int h = geth();
sliderStateThreshold = h / 2;
sM = m_REGULAR;
                setStopValues((float) h - collapsedh);
                break;
            case m_FIXED:
                sliderStateThreshold = Integer.MAX_VALUE;
        sM = m_FIXED;
    getLayoutParams().h = collapsedh;
                setStopValues(0f);
      break;
        }
        enableSlide(m != m_FIXED);
    }