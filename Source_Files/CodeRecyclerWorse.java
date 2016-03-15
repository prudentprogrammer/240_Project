	public int recycleItems(LinearLayout layout, int firstItem, ItemsRange range) {
int index = firstItem;
		for (int i = 0; i < layout.getChildCount();) {if (!range.contains(index)) { recycleView(layout.getChildAt(i), index); layout.removeViewAt(i); if (i == 0) { firstItem++;}} else{i++; // go to next item}index++;}
return firstItem;