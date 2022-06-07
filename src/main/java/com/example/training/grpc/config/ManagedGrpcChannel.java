package com.example.training.grpc.config;

import io.dropwizard.lifecycle.Managed;
import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;
import io.grpc.ManagedChannel;
import org.eclipse.jetty.util.component.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkNotNull;

public class ManagedGrpcChannel implements Managed {
    private static final Logger log = LoggerFactory.getLogger(ManagedGrpcChannel.class);

    private final ManagedChannel channel;
    private final Duration disconnectTimeout;

    public ManagedGrpcChannel(final ManagedChannel channel) {
        this(channel, Duration.seconds(5));
    }

    public ManagedGrpcChannel(final ManagedChannel channel, final Duration disconnectTimeout) {
        this.channel = checkNotNull(channel, "channel");
        this.disconnectTimeout = checkNotNull(disconnectTimeout, "disconnectTimeout");
    }

    public void start() throws Exception {}

    public void stop() throws Exception {
        log.info("Disconnecting gRPC client", channel);
        channel.shutdown().awaitTermination(disconnectTimeout.getQuantity(), disconnectTimeout.getUnit());
        log.info("gRPC client disconnected");
    }
}