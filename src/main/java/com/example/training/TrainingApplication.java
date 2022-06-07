package com.example.training;

import com.example.training.client.AccountServiceImpl;
import com.example.training.db.AccountDAO;
import com.example.training.resources.AccountResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.grpc.ManagedChannel;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class TrainingApplication extends Application<TrainingConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TrainingApplication().run(args);
    }

    @Override
    public String getName() {
        return "training";
    }

    @Override
    public void run(final TrainingConfiguration configuration,
                    final Environment environment) {
        AccountDAO accountDAO = new AccountDAO(createInstanceElasticsearchClient());
        configuration.getGrpcServerFactory()
                .builder(environment)
                .addService(new AccountServiceImpl(accountDAO))
                .build();
        final ManagedChannel externalServiceChannel = configuration.getExternalGrpcChannelFactory()
                .build(environment);
        environment.jersey().register(new AccountResource(externalServiceChannel));

    }

    private RestHighLevelClient createInstanceElasticsearchClient() {
        final Header[] headers = new Header[]{new BasicHeader(CONTENT_TYPE, APPLICATION_JSON),
                new BasicHeader("X-Elastic-Product", "Elasticsearch")};
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200))
                .setDefaultHeaders(headers);
        return new RestHighLevelClient(restClientBuilder);
    }
}
