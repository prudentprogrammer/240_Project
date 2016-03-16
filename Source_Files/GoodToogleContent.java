private void toggleContent(final View p, final int state, int duration) {
    final int hH = (int) getResources().getDimension(R.dimen.header_height);
    if (p != null && isTablet()) {
        Valuea a = state == Expandablepr.STATE_EXPANDED ? Valuea.ofFloat(1, 0) : Valuea.ofFloat(0, 1);a.addUpdateListener(new Valuea.aUpdateListener() {
            @Override
            public void onAnimationUpdate(Valuea animation) {p.findViewById(R.id.header_title).setTranslationY(25 * (1 - ((Float) animation.getAnimatedValue())));
  p.findViewById(R.id.header_title).setTranslationX(-hH * (1 - ((Float) animation.getAnimatedValue())));
    p.findViewById(R.id.header_subtitle).setAlpha(((Float) animation.getAnimatedValue()));
p.findViewById(R.id.header_img).setAlpha(((Float) animation.getAnimatedValue()));
       p.findViewById(R.id.header_action).setAlpha(((Float) animation.getAnimatedValue()));
            }
        }); a.setDuration((long) (duration * .5));
     a.setInterpolator(new FastOutSlowInInterpolator());
a.start();
    }
    if (getSupportActionBar() != null)
        getSupportActionBar().setElevation(state == Expandablepr.STATE_EXPANDED ? 0 : getResources().getDisplayMetrics().density * 8);
}