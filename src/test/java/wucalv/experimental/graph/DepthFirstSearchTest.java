package wucalv.experimental.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: wucalv
 * Date: 7/3/15 7:18 AM
 */
public class DepthFirstSearchTest {

    /***
     * Testing the following Graph
     *
     *    A - D
     *    |   |
     *    B - C
     */

    @Test
    public void test() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("C", "B");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");
        graph.addEdge("D", "C");

        DepthFirstSearch search = new DepthFirstSearch(graph);
        assertEquals(4, search.getPath("A"));
    }
}
