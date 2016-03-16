private void setSliderMode(@SliderMode byte mode) {
        switch (mode) {
            case MODE_REGULAR: // full screen
                int height = getHeight();
                sliderStateThreshold = height / 2;
                sliderMode = MODE_REGULAR;
                setStopValues((float) height - collapsedHeight);
                break;
            case MODE_FIXED:
                sliderStateThreshold = Integer.MAX_VALUE;
                sliderMode = MODE_FIXED;
                getLayoutParams().height = collapsedHeight;
                setStopValues(0f);
                break;
        }
        enableSlide(mode != MODE_FIXED);
    }