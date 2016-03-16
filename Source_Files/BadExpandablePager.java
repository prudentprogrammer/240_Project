public void seta(ExpandablePagera a) {
        int i = mP.getCurrentItem();
        mP.seta(a);
    mP.setCurrentItem(Math.min(i, a.getCount() - 1));
    mP.post(new Runnable() {
            @Override
            public void run() {
                if (onSliderStateChangeListener != null) {
                    onSliderStateChangeListener.onPageChanged(getPage(mP.getCurrentItem()), sliderState);
                }
            }
        });
    }