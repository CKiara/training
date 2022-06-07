package com.example.grpcserver.config.elasticsearch;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;

@Getter
@Setter
public class ElasticsearchClientFactory {

  @NotEmpty(message = "Elasticsearch Hostname is empty or null")
  private String hostname;

  @NotNull(message = "Elasticsearch Port is null")
  @Min(value = 0, message = "Elasticsearch Port must be greater than or equal to 0")
  @Max(value = 65535, message = "Elasticsearch Port must be less than or equal to 65535")
  private Integer port;

  public ElasticsearchClientBuilder builder() {
    return new ElasticsearchClientBuilder(new HttpHost(hostname, port));
  }

}
