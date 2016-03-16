/**
     * Returns the size of the longest path for the current node.
     */
    public int getLongestPathSize() {
        if (children.isEmpty()) {
            return 0;
        } else {
            int c = children.size();
            int m = 0, aux;
            for (Node<T> n : children) {
                aux = n.getLongestPathSize();
                if (aux > m)
                    m = aux;
            }
            return c + m;
        }
    }