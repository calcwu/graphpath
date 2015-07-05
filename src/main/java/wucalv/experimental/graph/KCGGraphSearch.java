package wucalv.experimental.graph;

import com.gs.collections.api.set.ImmutableSet;
import com.gs.collections.impl.factory.Sets;

/**
 * User: wucalv
 * Date: 7/5/15 11:43 AM
 */
public class KCGGraphSearch extends DepthFirstSearch<String> {

    private static final int MAX_VOWEL_COUNT = 2;

    private ImmutableSet<String> VOWELS = Sets.immutable.of("A", "E", "I", "O", "U");

    public KCGGraphSearch(Graph<String> graph, int maxVertexVisits) {
        super(graph, maxVertexVisits);
    }

    public KCGGraphSearch(Graph<String> graph) {
        super(graph);
    }

    @Override
    protected boolean keepTraversing(String vertex) {
        boolean isVowel = VOWELS.contains(vertex);
        return isVowel? keepTraversing(vertex, MAX_VOWEL_COUNT) : super.keepTraversing(vertex);
    }

    @Override
    protected void markVertexAsVisted(String vertex) {
        super.markVertexAsVisted(vertex);
    }
}
