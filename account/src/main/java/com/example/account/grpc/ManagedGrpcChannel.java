package com.example.account.grpc;

import static com.google.common.base.Preconditions.checkNotNull;

import io.dropwizard.lifecycle.Managed;
import io.dropwizard.util.Duration;
import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagedGrpcChannel implements Managed {

    private static final Logger log = LoggerFactory.getLogger(ManagedGrpcChannel.class);
    private final ManagedChannel channel;
    private final Duration disconnectTimeout;

    public ManagedGrpcChannel(final ManagedChannel channel, final Duration disconnectTimeout) {
        this.channel = checkNotNull(channel, "Channel is null");
        this.disconnectTimeout = checkNotNull(disconnectTimeout, "DisconnectTimeout is null");
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() throws Exception {
        log.info("Disconnecting gRPC client");
        channel.shutdown().awaitTermination(disconnectTimeout.getQuantity(), disconnectTimeout.getUnit());
        log.info("gRPC client disconnected");
    }
}