import java.util.ArrayList;

public class Position {

    double x;
    double y;

    // Constructor to initialize position with given x and y coordinates
    Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Default constructor initializes position to (0,0)
    Position() {
        x = 0;
        y = 0;
    }

    // Getter method for x-coordinate
    public double getX() {
        return x;
    }

    // Getter method for y-coordinate
    public double getY() {
        return y;
    }

    // Converts position to a readable string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
