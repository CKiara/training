package com.example.training.grpc.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;
import io.grpc.ServerBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class GrpcServerFactory {
    @Min(0)
    @Max(65535)
    private int port = 8080;

    @NotEmpty
    private String hostname;

    private final Duration shutdownPeriod = Duration.seconds(5);

    @JsonProperty("port")
    public int getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(final int port) {
        this.port = port;
    }

    @JsonProperty
    public String getHostname() {
        return hostname;
    }

    @JsonProperty
    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    public ServerBuilder<?> builder(final Environment environment) {
        final ServerBuilder<?> originBuilder = ServerBuilder.forPort(port);
        return new DropwizardServerBuilder(environment, originBuilder, shutdownPeriod);
    }
}
