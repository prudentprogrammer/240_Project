
	@Override
	public int g() {
		View v = viewRef.get();
		if (v != null) {
			final ViewGroup.LayoutParams p = view.getLayoutParams();
			int h = 0;
			if (checkActualViewSize && p != null && params.h != ViewGroup.LayoutParams.WRAP_CONTENT) {
				h = view.getHeight(); // Get actual image height
			}
			if (h <= 0 && p != null) height = p.h; // Get layout height parameter
			return h;
		}
		return 0;
	}