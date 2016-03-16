private void init() {
        mPager = new ViewPager(getContext());
        mPager.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean change = true;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (change) {
                    if (onSliderStateChangeListener != null) {
                        onSliderStateChangeListener.onPageChanged(getPage(mPager.getCurrentItem() + (position < mPager.getCurrentItem() ? -1 : 1)), sliderState);
                        change = !change;
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (onItemSelectedListener != null)
                    onItemSelectedListener.onItemSelected(((ExpandablePagerAdapter) mPager.getAdapter()).items, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                change = true;
            }
        });
        addView(mPager);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                pinToBottom();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (onSliderStateChangeListener != null) {
                    onSliderStateChangeListener.onPageChanged(getPage(mPager.getCurrentItem()), sliderState);
                }
            }
        });
    }