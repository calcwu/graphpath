package wucalv.experimental.dw;

import io.dropwizard.cli.ConfiguredCommand;
import io.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import wucalv.experimental.graph.Graph;
import wucalv.experimental.graph.GraphSearch;
import wucalv.experimental.graph.CustomGraphSearch;
import wucalv.experimental.graph.KeyPad;
import wucalv.experimental.graph.KeyPadBuilder;
import wucalv.experimental.graph.KeyPadToGraphFunction;

/**
 * User: wucalv
 * Date: 7/5/15 5:04 PM
 */
public class RunGraphCommand extends ConfiguredCommand<GraphAppConfiguration> {

    protected RunGraphCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void configure(Subparser subparser) {
//        super.configure(subparser);
        subparser.addArgument("-n")
                .action(Arguments.store())
                .dest("n")
                .help("Enter n, between 1 and 32");

    }

    @Override
    protected void run(Bootstrap<GraphAppConfiguration> bootstrap, Namespace namespace, GraphAppConfiguration graphAppConfiguration) throws Exception {
        String n = namespace.get("n");
        KeyPad keyPad = KeyPadBuilder.buildDefault();
        Graph<String> graph = new KeyPadToGraphFunction().valueOf(keyPad);
        GraphSearch<String> search = new CustomGraphSearch(graph, Integer.valueOf(n));
        System.out.println(search.getPath("A"));
    }
}
