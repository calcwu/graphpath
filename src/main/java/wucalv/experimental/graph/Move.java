package wucalv.experimental.graph;

/**
 * User: wucalv
 * Date: 6/27/15 10:52 PM
 */
public interface Move {

    /**
     *
     * @param point
     * @return possible moves from the input point
     */
    Point[] getNextMoves(Point point, Point boundary);
}
