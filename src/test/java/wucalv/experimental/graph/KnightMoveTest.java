package wucalv.experimental.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: wucalv
 * Date: 6/27/15 11:36 PM
 */
public class KnightMoveTest {

    @Test
    public void test() {

        KnightMove move = new KnightMove();
        Point b = new Point(5, 4);
        assertEquals(0, move.getNextMoves(new Point(-1, -1), b).length);
        assertEquals(2, move.getNextMoves(new Point(0, 0), b).length);
        assertEquals(3, move.getNextMoves(new Point(1, 0), b).length);
        assertEquals(4, move.getNextMoves(new Point(2, 0), b).length);
        assertEquals(3, move.getNextMoves(new Point(0, 1), b).length);
        assertEquals(4, move.getNextMoves(new Point(0, 2), b).length);
        assertEquals(8, move.getNextMoves(new Point(2, 2), b).length);

    }
}
