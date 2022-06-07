package com.example.grpcserver.config.elasticsearch;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticsearchClientBuilder  {

  private HttpHost httpHost;
  private Header[] headers;

  public ElasticsearchClientBuilder(HttpHost httpHost) {
    this.httpHost = checkNotNull(httpHost, "HttpHost is null");
  }

  public ElasticsearchClientBuilder addHeaders(Header[] headers) {
    this.headers = headers;
    return this;
  }

  public RestHighLevelClient build() {
    RestClientBuilder restClientBuilder = RestClient.builder(httpHost).setDefaultHeaders(headers);
    return new RestHighLevelClient(restClientBuilder);
  }
}
