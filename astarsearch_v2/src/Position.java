/**
 * Created by root on 9/9/15.
 */
public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isSamePosition(Position goal) {
        return (x == goal.x) && (y == goal.y);
    }

    public String toString() {
        return "Position (" + x + "," + y + ")";
    }
}
