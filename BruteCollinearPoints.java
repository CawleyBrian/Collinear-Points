/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.ArrayList;
import java.util.List;


public class BruteCollinearPoints {
    private LineSegment[] lineSegments;


    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        // check array is not null;
        if (points == null) throw new NullPointerException("Array is null");

        // verify all points are not null;
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException("Null point in array");
            }
        }
        // store n for checks
        int n = points.length;

        // Point[] copy = points.clone();
        // Arrays.sort(copy);
        List<LineSegment> list = new ArrayList<>();
        // For each point, loop every possible combination of 4 points.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {

                        // create 4 points to be compared
                        Point[] p = new Point[4];
                        p[0] = points[i];
                        p[1] = points[j];
                        p[2] = points[k];
                        p[3] = points[l];

                        // compare slope of 1st point with the other 3
                        double slope1 = p[0].slopeTo(p[1]);
                        double slope2 = p[0].slopeTo(p[2]);
                        double slope3 = p[0].slopeTo(p[3]);

                        // if all on same slope, create line segment between 1st and 4th point
                        if (slope1 == slope2 && slope1 == slope3) {
                            // Arrays.sort(p);
                            list.add(new LineSegment(p[0], p[3]));
                        }
                    }
                }
            }
        }
        // add all line segments with 4 points to class variable
        this.lineSegments = list.toArray(new LineSegment[list.size()]);
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return this.lineSegments;
    }


    public static void main(String[] args) {

    }
}
