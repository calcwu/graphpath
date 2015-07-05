package wucalv.experimental.graph;

import java.util.Set;

import com.gs.collections.api.block.function.Function;

/**
 * User: wucalv
 * Date: 7/5/15 12:13 PM
 */
public class KeyPadToGraphFunction implements Function<KeyPad, Graph<String>> {

    @Override
    public Graph<String> valueOf(KeyPad keyPad) {
        Graph<String> graph = new Graph<>();
        if(keyPad == null) {
            return graph;
        }

        KeyPadControl keyPadControl = new KeyPadControl(keyPad);
        Set<String> keys = keyPad.getAllKeys();
        for(String s : keys) {
            addEdge(graph, keyPadControl, s);
        }
        return graph;
    }

    private void addEdge(Graph<String> graph, KeyPadControl keyPadControl, String vertex) {
        String[] vertices = keyPadControl.getPossibleMoves(Moves.KnightMove, vertex);
        for(String v : vertices) {
            graph.addEdge(vertex, v);
            if(!graph.containsKey(v)) {
                addEdge(graph, keyPadControl, v);
            }
        }
    }
}
