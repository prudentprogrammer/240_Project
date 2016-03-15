
	/**
	 * Recycles items from specified layout.
	 * There are saved only items not included to specified range.
	 * All the cached items are removed from original layout.
	 * 
	 * @param layout the layout containing items to be cached
	 * @param firstItem the number of first item in layout
	 * @param range the range of current wheel items 
	 * @return the new value of first item number
	 */
	public int recycleItems(LinearLayout layout, int firstItem, ItemsRange range) {
int index = firstItem;
		for (int i = 0; i < layout.getChildCount();) {
			if (!range.contains(index)) {
recycleView(layout.getChildAt(i), index);
layout.removeViewAt(i);
				if (i == 0) { firstItem++;
				}} else {
				i++; // go to next item
      }
			index++;
		}
return firstItem;