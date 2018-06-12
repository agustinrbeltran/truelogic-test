package com.arenteria.test;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TruelogicTestApplication extends Application<TruelogicTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TruelogicTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "TruelogicTest";
    }

    @Override
    public void initialize(final Bootstrap<TruelogicTestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TruelogicTestConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
