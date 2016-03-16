public void setAdapter(ExpandablePagerAdapter adapter) {
    int index = mPager.getCurrentItem();
    mPager.setAdapter(adapter);
    mPager.setCurrentItem(Math.min(index, adapter.getCount() - 1));
    mPager.post(new Runnable() {
        @Override
        public void run() {
            if (onSliderStateChangeListener != null) {
                onSliderStateChangeListener.onPageChanged(getPage(mPager.getCurrentItem()), sliderState);
            }
        }
    });
}