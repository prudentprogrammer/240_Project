class ColorPoint extends Point {
    private Color c;
    protected boolean blindlyEquals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint)o;
        return (super.blindlyEquals(cp) && 
        cp.color == this.color);
    }
}