/**
     * Extracts a value from the current stash
     * The stash contains fields eventually extracted from previous responses that can be reused
     * as arguments for following requests (e.g. scroll_id)
     */
    public Object unstashValue(String value) {
        Object stashedValue = stash.get(value.substring(1));
        if (stashedValue == null) {
            throw new IllegalArgumentException("stashed value not found for key [" + value + "]");
        }
        return stashedValue;
    }
