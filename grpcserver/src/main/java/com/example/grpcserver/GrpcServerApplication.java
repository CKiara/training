package com.example.grpcserver;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.example.grpcserver.core.AccountServiceImpl;
import com.example.grpcserver.db.AccountDAO;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestHighLevelClient;

public class GrpcServerApplication extends Application<GrpcServerConfiguration> {

  public static final Header[] HEADERS = {new BasicHeader(CONTENT_TYPE, APPLICATION_JSON)};

  public static void main(final String[] args) throws Exception {
    new GrpcServerApplication().run(args);
  }

  @Override
  public String getName() {
    return "GrpcServer";
  }

  @Override
  public void initialize(final Bootstrap<GrpcServerConfiguration> bootstrap) {
    // TODO: application initialization
  }

  @Override
  public void run(final GrpcServerConfiguration configuration,
      final Environment environment) {
    RestHighLevelClient elasticsearchClient = configuration
        .getElasticsearch()
        .builder()
        .addHeaders(HEADERS)
        .build();
    AccountDAO accountDAO = new AccountDAO(elasticsearchClient);
    configuration
        .getGrpcServer()
        .builder(environment)
        .addService(new AccountServiceImpl(accountDAO))
        .build();
  }
}
