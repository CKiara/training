package com.example.common;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CommonApplication extends Application<CommonConfiguration> {

    public static void main(final String[] args) throws Exception {
        new com.example.common.CommonApplication().run(args);
    }

    @Override
    public String getName() {
        return "Common";
    }

    @Override
    public void initialize(final Bootstrap<CommonConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final CommonConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
