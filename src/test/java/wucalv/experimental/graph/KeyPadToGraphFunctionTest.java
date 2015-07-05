package wucalv.experimental.graph;

import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * User: wucalv
 * Date: 7/5/15 3:28 PM
 */
public class KeyPadToGraphFunctionTest {

    @Test
    public void test() {
        KeyPad keyPad = new KeyPadBuilder().append("ABC", "DEF", "GHI").build();

        assertEquals(3, keyPad.getRowSize());
        assertEquals(new Point(3, 3), keyPad.getBoundary());

        Graph graph = new KeyPadToGraphFunction().valueOf(keyPad);
        assertEquals(8, graph.getEdges());
        Set<String> set = graph.getVertices("E");
        assertNull(set);

        set = graph.getVertices("F");
        assertEquals(2, set.size());
        assertTrue(set.contains("A"));
        assertTrue(set.contains("G"));
    }


    @Test
    public void test2() {
        KeyPad keyPad = new KeyPadBuilder().append("ABC", "DEF", "*H*").build();

        assertEquals(3, keyPad.getRowSize());
        assertEquals(new Point(3, 3), keyPad.getBoundary());

        Graph graph = new KeyPadToGraphFunction().valueOf(keyPad);
        assertEquals(4, graph.getEdges());
        Set<String> set = graph.getVertices("E");
        assertNull(set);

        set = graph.getVertices("F");
        assertEquals(1, set.size());
        assertTrue(set.contains("A"));

        set = graph.getVertices("B");
        assertNull(set);
    }

}
