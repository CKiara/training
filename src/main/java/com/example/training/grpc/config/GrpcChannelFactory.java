package com.example.training.grpc.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import io.grpc.ManagedChannelBuilder;

public class GrpcChannelFactory {
    @NotEmpty
    private String hostname;

    @Min(1)
    @Max(65535)
    private int port = -1;

    @MinDuration(1)
    private Duration shutdownPeriod = Duration.seconds(5);

    @JsonProperty
    public String getHostname() {
        return hostname;
    }

    @JsonProperty
    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(final int port) {
        this.port = port;
    }

    @JsonProperty
    public Duration getShutdownPeriod() {
        return shutdownPeriod;
    }

    @JsonProperty
    public void setShutdownPeriod(final Duration duration) {
        this.shutdownPeriod = duration;
    }

    public ManagedChannelBuilder builder() {
        return ManagedChannelBuilder.forAddress(getHostname(), getPort());
    }

    public ManagedChannel build(final Environment environment) {
        final ManagedChannel managedChannel;
        managedChannel = builder().usePlaintext().build();
        environment.lifecycle().manage(new ManagedGrpcChannel(managedChannel, shutdownPeriod));
        return managedChannel;
    }
}
