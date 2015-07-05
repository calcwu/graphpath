package wucalv.experimental.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: wucalv
 * Date: 7/2/15 10:14 PM
 */
public class Graph<T> {

    private Map<T, Set<T>> vertices;

    private int edges;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(T v1, T v2) {
        addVertex(v1);
        addVertex(v2);
        if(!vertices.get(v1).contains(v2)) {
            edges++;
        }
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }

    public void addVertex(T v) {
        if(!vertices.containsKey(v)) {
            vertices.put(v, new HashSet<T>());
        }
    }

    public Set<T> getVertices(T v) {
        return vertices.get(v);
    }

    public boolean containsKey(T vertex) {
        return vertices.containsKey(vertex);
    }

    public int getEdges() {
        return edges;
    }
}
