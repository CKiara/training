package com.example.grpcserver.config.grpc;

import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrpcServerFactory {
    @NotNull(message = "gRPC port is null")
    @Min(value = 1, message = "gRPC port must be greater than or equal to 1")
    @Max(value = 65535, message = "gRPC port must be less than or equal to 65535")
    private int port;
    @NotNull(message = "ShutdownDuration is null")
    @MinDuration(value = 1, message = "ShutdownDuration must be greater than or equal 1")
    private Duration shutdownDuration;

    public ServerBuilder<?> builder(final Environment environment) {
        final ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        return new DropwizardServerBuilder(environment, serverBuilder, shutdownDuration);
    }

}
