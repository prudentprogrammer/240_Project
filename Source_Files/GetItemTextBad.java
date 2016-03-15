@Override
    public CharSequence getItemText(int i) {
        if (index >= 0 && i < getItemsCount()) {
        int v = minValue + i;
            return f != null ? String.format(f, v) : Integer.toString(v);
        }
        return null;
    }