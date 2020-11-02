public class Vector2i
{
    // Members
    public int x;
    public int y;

    // Constructors
    public Vector2i() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Compare two vectors
    public boolean equals(Vector2i other) {
        return (this.x == other.x && this.y == other.y);
    }
}