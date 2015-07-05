package wucalv.experimental.graph;

import org.junit.Test;

/**
 * User: wucalv
 * Date: 7/5/15 12:30 PM
 */
public class IntegrationTest {

    @Test
    public void test() {
        KeyPad keyPad = KeyPadBuilder.buildDefault();
        Graph<String> graph = new KeyPadToGraphFunction().valueOf(keyPad);
        long count = 0;
        for(String k : keyPad.getAllKeys()) {
            GraphSearch<String> search = new KCGGraphSearch(graph, 10);
            long paths = search.getPath(k);
            count += paths;
            System.out.println(k + " : " + paths + ", " + count);
        }
    }

    @Test
    public void testKCG() {
        int input = Integer.valueOf(System.getProperty("n"));
        KeyPad keyPad = KeyPadBuilder.buildDefault();
        Graph<String> graph = new KeyPadToGraphFunction().valueOf(keyPad);
        GraphSearch<String> search = new KCGGraphSearch(graph, input);
        System.out.println(search.getPath("A"));
    }
}
