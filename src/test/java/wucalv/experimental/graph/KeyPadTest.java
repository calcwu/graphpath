package wucalv.experimental.graph;

import java.util.Set;

import com.gs.collections.api.set.ImmutableSet;
import com.gs.collections.impl.factory.Sets;
import com.gs.collections.impl.list.mutable.FastList;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 *  A B C D E
 *  F G H I J
 *  K L M N O
 *    1 2 3

 * User: wucalv
 * Date: 6/27/15 10:25 PM
 */
public class KeyPadTest {

    @Test
    public void test() {
        KeyPad kp = KeyPadBuilder.buildDefault();
        assertEquals("K", kp.getKey(0, 2));
        assertEquals("2", kp.getKey(2, 3));
        assertEquals("J", kp.getKey(4, 1));

        assertEquals(new Point(0, 0), kp.getPoint("A"));
        assertEquals(new Point(0, 2), kp.getPoint("K"));
        assertEquals(new Point(2, 3), kp.getPoint("2"));
        assertEquals(new Point(4, 1), kp.getPoint("J"));

        //make sure data is correct
        Set<String> keys = kp.getAllKeys();
        for(String s : keys) {
            Point p = kp.getPoint(s);
            assertEquals(s, kp.getKey(p));
        }
    }

    @Test
    public void testKeyPadControl() {
        KeyPad kp = KeyPadBuilder.buildDefault();
        KeyPadControl keyPadControl = new KeyPadControl(kp);

        String[] moves = keyPadControl.getPossibleMoves(Moves.KnightMove, "A");
        ImmutableSet<String> set = Sets.immutable.of(moves);
        assertEquals(2, set.size());
        assertTrue(set.contains("L"));
        assertTrue(set.contains("H"));

        moves = keyPadControl.getPossibleMoves(Moves.KnightMove, "1");
        set = Sets.immutable.of(moves);
        assertEquals(3, set.size());
        assertTrue(set.contains("F"));
        assertTrue(set.contains("H"));
        assertTrue(set.contains("N"));
    }
}
