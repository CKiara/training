package com.example.account.grpc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrpcChannelFactory {
    @NotEmpty
    private String hostname;

    @NotNull(message = "gRPC Channel port is null")
    @Min(value = 1, message = "gRPC Channel port must be greater than or equal to 1")
    @Max(value = 65535, message = "gRPC Channel port must be less than or equal to 65535")
    private int port = -1;

    @NotNull(message = "ShutdownDuration is null")
    @MinDuration(value = 1, message = "ShutdownDuration must be greater than or equal 1")
    private Duration shutdownDuration;
    public ManagedChannelBuilder builder() {
        return ManagedChannelBuilder.forAddress(hostname, port);
    }

    public ManagedChannel build(final Environment environment) {
        ManagedChannel managedChannel = builder().usePlaintext().build();
        environment.lifecycle().manage(new ManagedGrpcChannel(managedChannel, shutdownDuration));
        return managedChannel;
    }
}
