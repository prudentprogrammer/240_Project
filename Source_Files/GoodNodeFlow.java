/**
     * Returns the size of the longest path for the current node.
     */
    public int getLongestPathSize() {
        if (children.isEmpty()) {
            return 0;
        } else {
            int count = children.size();
            int max = 0, aux;
            for (Node<T> n : children) {
                aux = n.getLongestPathSize();
                if (aux > max)
                    max = aux;
            }
            return count + max;
        }
    }