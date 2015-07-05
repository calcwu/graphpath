package wucalv.experimental.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: wucalv
 * Date: 7/5/15 12:01 PM
 */
public class KCGGraphSearchTest {

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

        KCGGraphSearch search = new KCGGraphSearch(graph, 3);
        assertEquals(11, search.getPath("A"));
    }


}
