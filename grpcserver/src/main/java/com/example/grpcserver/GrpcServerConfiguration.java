package com.example.grpcserver;

import com.example.grpcserver.config.elasticsearch.ElasticsearchClientFactory;
import com.example.grpcserver.config.grpc.GrpcServerFactory;
import io.dropwizard.Configuration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrpcServerConfiguration extends Configuration {
  @Valid
  @NotNull
  private GrpcServerFactory grpcServer;

  @Valid
  @NotNull
  private ElasticsearchClientFactory elasticsearch;

}
