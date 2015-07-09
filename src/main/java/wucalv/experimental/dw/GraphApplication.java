package wucalv.experimental.dw;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * User: wucalv
 * Date: 7/5/15 5:00 PM
 */
public class GraphApplication extends Application<GraphAppConfiguration> {

    @Override
    public void initialize(Bootstrap<GraphAppConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addCommand(new RunGraphCommand("kcg", "Kcg code test"));
    }

    @Override
    public void run(GraphAppConfiguration graphAppConfiguration, Environment environment) throws Exception {
        environment.jersey().disable();
    }

    public static void main(String[] args) throws Exception {
        new GraphApplication().run(args);
    }
}
