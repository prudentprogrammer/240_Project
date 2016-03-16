private void toggleContent(final View page, final int state, int duration) {
    final int headerHeight = (int) getResources().getDimension(R.dimen.header_height);
    if (page != null && isTablet()) {
        ValueAnimator animator = state == ExpandablePager.STATE_EXPANDED ? ValueAnimator.ofFloat(1, 0) : ValueAnimator.ofFloat(0, 1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                page.findViewById(R.id.header_title).setTranslationY(25 * (1 - ((Float) animation.getAnimatedValue())));
                page.findViewById(R.id.header_title).setTranslationX(-headerHeight * (1 - ((Float) animation.getAnimatedValue())));
                page.findViewById(R.id.header_subtitle).setAlpha(((Float) animation.getAnimatedValue()));
                page.findViewById(R.id.header_img).setAlpha(((Float) animation.getAnimatedValue()));
                page.findViewById(R.id.header_action).setAlpha(((Float) animation.getAnimatedValue()));
            }
        });
        animator.setDuration((long) (duration * .5));
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }
    if (getSupportActionBar() != null)
        getSupportActionBar().setElevation(state == ExpandablePager.STATE_EXPANDED ? 0 : getResources().getDisplayMetrics().density * 8);
}