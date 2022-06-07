package com.example.account;

import com.example.account.resources.AccountResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.grpc.ManagedChannel;

public class AccountApplication extends Application<AccountConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AccountApplication().run(args);
    }

    @Override
    public String getName() {
        return "Account";
    }

    @Override
    public void initialize(final Bootstrap<AccountConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final AccountConfiguration configuration,
                    final Environment environment) {
        ManagedChannel externalService = configuration.getExternalService()
                                                      .build(environment);
        environment.jersey().register(new AccountResource(externalService));
    }

}
