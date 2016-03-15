class Point {
    private int x;
    private int y;
    protected boolean blindlyEquals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return (p.x == this.x && p.y == this.y);
    }
    public boolean equals(Object o) {
        return (this.blindlyEquals(o) && o.blindlyEquals(this));
    }
}
