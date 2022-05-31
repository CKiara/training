package com.example.training;

import com.example.training.grpc.config.GrpcChannelFactory;
import com.example.training.grpc.config.GrpcServerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TrainingConfiguration extends Configuration {
    @Valid
    @NotNull
    private GrpcServerFactory grpcServer = new GrpcServerFactory();

    @JsonProperty("grpcServer")
    public GrpcServerFactory getGrpcServerFactory() {
        return grpcServer;
    }

    @JsonProperty("grpcServer")
    public void setGrpcServerFactory(final GrpcServerFactory grpcServer) {
        this.grpcServer = grpcServer;
    }

    @Valid
    @NotNull
    private GrpcChannelFactory externalService = new GrpcChannelFactory();

    @JsonProperty("externalService")
    public GrpcChannelFactory getExternalGrpcChannelFactory() {
        return externalService;
    }

    @JsonProperty("externalService")
    public void setExternalGrpcChannelFactory(final GrpcChannelFactory externalService) {
        this.externalService = externalService;
    }
}
