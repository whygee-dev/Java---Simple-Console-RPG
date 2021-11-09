package math;

public class Vector2i {
    private int x,y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Vector2i v) {
        if (v == null) {
            return false;
        }

        if (v == this) {
            return true;
        }

        return v.getY() == getY() && v.getX() == getX();
    }
}
