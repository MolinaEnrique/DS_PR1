package edu.uoc.ds.adt.util;

public class SpiralGenerator {
    public static Point[] generate(double a, double b, double thetaMax, double step) {
        java.util.List<Point> pointsList = new java.util.ArrayList<>();
        for (double theta = 0; theta < thetaMax; theta += step) {
            double r = a + b * theta;
            double x = r * Math.cos(theta);
            double y = r * Math.sin(theta);
            pointsList.add(new Point(x, y));
        }
        return pointsList.toArray(new Point[0]);
    }
}
