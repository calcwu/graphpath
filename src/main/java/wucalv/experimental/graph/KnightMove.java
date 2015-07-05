package wucalv.experimental.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Knight always has 8 possible destinations.
 *
 * User: wucalv
 * Date: 6/27/15 10:53 PM
 */
public class KnightMove implements Move {

    @Override
    public Point[] getNextMoves(Point point, Point boundary) {
        if(!isValid(point) || !isValid(boundary)) {
            return new Point[0];
        }
        List<Point> points = new ArrayList<Point>();
        int x = point.getX(), y = point.getY();

        //right/left down
        points.add(new Point(x+1, y+2));
        points.add(new Point(x-1, y+2));

        //right/left up
        points.add(new Point(x+1, y-2));
        points.add(new Point(x-1, y-2));


        //right/left short down
        points.add(new Point(x+2, y+1));
        points.add(new Point(x-2, y+1));

        //right/left short up
        points.add(new Point(x+2, y-1));
        points.add(new Point(x-2, y-1));

        //validate
        for(Iterator<Point> ii = points.iterator(); ii.hasNext();) {
            Point p = ii.next();
            if(!p.isValid() || p.getX() > boundary.getX() || p.getY() > boundary.getY()) {
                ii.remove();
            }
        }
        return points.toArray(new Point[points.size()]);
    }

    private boolean isValid(Point p) {
        return p !=null && p.isValid();
    }
}
