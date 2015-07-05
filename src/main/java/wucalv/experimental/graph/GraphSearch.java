package wucalv.experimental.graph;

/**
 * User: wucalv
 * Date: 7/4/15 9:40 AM
 */
public interface GraphSearch<T> {

    Graph<T> getGraph();

    long getPath(T vertex);
}
