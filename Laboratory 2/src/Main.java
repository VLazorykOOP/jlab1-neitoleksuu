
import java.util.Date;
import java.util.GregorianCalendar;
public class Main {
    public static void main(String[] args) {
        Point pointA = new Point(3, 4);
        Point pointB = new Point(6, 8);

        pointA.moveX(2);
        pointB.moveY(3);

        double distanceToOriginA = pointA.distanceToOrigin();
        double distanceToOriginB = pointB.distanceToOrigin();

        System.out.println("Distance to Origin for Point A: " + distanceToOriginA);
        System.out.println("Distance to Origin for Point B: " + distanceToOriginB);

        double distanceAB = pointA.distanceTo(pointB);
        System.out.println("Distance between Point A and Point B: " + distanceAB);

        double[] polarCoordinatesA = pointA.toPolarCoordinates();
        double[] polarCoordinatesB = pointB.toPolarCoordinates();

        System.out.println("Polar Coordinates for Point A: radius = " + polarCoordinatesA[0] + ", theta = " + polarCoordinatesA[1]);
        System.out.println("Polar Coordinates for Point B: radius = " + polarCoordinatesB[0] + ", theta = " + polarCoordinatesB[1]);

        boolean arePointsEqual = pointA.isEqual(pointB);
        boolean arePointsNotEqual = pointA.isNotEqual(pointB);

        System.out.println("Are Point A and Point B equal? " + arePointsEqual);
        System.out.println("Are Point A and Point B not equal? " + arePointsNotEqual);
    }
}