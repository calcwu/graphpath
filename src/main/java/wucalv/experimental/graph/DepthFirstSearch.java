package wucalv.experimental.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Default DFS search for undirected graph
 * User: wucalv
 * Date: 7/3/15 6:51 AM
 */
public class DepthFirstSearch<T> implements GraphSearch<T> {

    protected Map<T, Integer> visitedVertices = new HashMap<>();

    private long count = 0;

    private final int maxVisits;

    protected final Graph<T> graph;

    public DepthFirstSearch(Graph<T> graph, int maxVertexVisits) {
        this.maxVisits = maxVertexVisits;
        this.graph = graph;
    }

    public DepthFirstSearch(Graph<T> graph) {
        this(graph, 1);
    }

    @Override
    public Graph<T> getGraph() {
        return graph;
    }

    @Override
    public long getPath(T vertex) {
        search(graph, vertex);
        return count;
    }

    private void search(Graph<T> graph, T vertex) {
        count++;
        markVertexAsVisted(vertex);
        for(T vv : graph.getVertices(vertex)) {
            if(keepTraversing(vv)) {
                search(graph, vv);
            }
        }
    }

    protected boolean keepTraversing(T vertex) {
        return keepTraversing(vertex, maxVisits);
    }

    protected boolean keepTraversing(T vertex, int max) {
        Integer count = visitedVertices.get(vertex);
        return count == null || count < max;
    }

    protected void markVertexAsVisted(T vertex) {
        Integer count = visitedVertices.get(vertex);
        count = (count==null)? 1 : (count+1);

        //set count
        visitedVertices.put(vertex, count);
    }
}
