package wucalv.experimental.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: wucalv
 * Date: 6/29/15 11:41 PM
 */
public class GraphTest {

    /***
     * Testing the following Graph
     *
     *    A - D - F
     *    |     \ |
     *    B - C - E
     */
    @Test
    public void test() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("C", "B");
        graph.addEdge("C", "E");
        graph.addEdge("D", "A");
        graph.addEdge("D", "F");
        graph.addEdge("D", "E");
        graph.addEdge("E", "C");
        graph.addEdge("E", "D");
        graph.addEdge("E", "F");
        graph.addEdge("F", "D");
        graph.addEdge("F", "E");

        assertEquals(7, graph.getEdges());
        assertEquals(2, graph.getVertices("A").size());
        assertEquals(3, graph.getVertices("E").size());
    }
}
