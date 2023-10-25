import java.util.Date;
import java.util.GregorianCalendar;
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveX(double dx) {
        this.x += dx;
    }

    public void moveY(double dy) {
        this.y += dy;
    }

    public double distanceToOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distanceTo(Point otherPoint) {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double[] toPolarCoordinates() {
        double radius = Math.sqrt(this.x * this.x + this.y * this.y);
        double theta = Math.atan2(this.y, this.x);
        return new double[]{radius, theta};
    }

    public boolean isEqual(Point otherPoint) {
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    public boolean isNotEqual(Point otherPoint) {
        return !isEqual(otherPoint);
    }
}

