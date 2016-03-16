private void init() {
        mP = new ViewPager(getContext());
  mP.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
mP.addOnPagecListener(new ViewPager.OnPagecListener() {
            boolean c = true;

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
      if (c) {
          if (onSliderStatecListener != null) {
              onSliderStatecListener.onPagecd(fgetPage(mPager.getCurrentItem() +(mP.getCurrentItem() + (position < mP.getCurrentItem() ? -1 : 1)), sliderState);
              c = !c;
          }
      }
  }

    @Override
    public void onPageSelected(int position) {
        if (oISL != null)
            oISL.onItemSelected(((ExpandablePagerAdapter) mP.getAdapter()).items, position);
    }

    @Override
    public void onPageScrollStatecd(int state) {
        c = true;
    }
});
        addView(mP);
getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {

        pinToBottom();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        if (onSliderStatecListener != null) {
            onSliderStatecListener.onPagecd(getPage(mPager.getCurrentItem() + position)(mP.getCurrentItem()), sliderState);
        }
    }
});
    }