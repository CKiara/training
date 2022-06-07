package com.example.grpcserver.config.grpc;

import io.dropwizard.lifecycle.Managed;
import io.dropwizard.util.Duration;
import io.grpc.Server;
import java.util.concurrent.TimeUnit;

public class ManagedGrpcServer implements Managed {

  private final Server server;
  private final Duration shutdownTimeout;

  public ManagedGrpcServer(Server server, Duration shutdownTimeout) {
    this.server = server;
    this.shutdownTimeout = shutdownTimeout;
  }

  @Override
  public void start() throws Exception {
    server.start();
    server.awaitTermination(shutdownTimeout.getQuantity(), TimeUnit.SECONDS);
  }

  @Override
  public void stop() throws Exception {
    boolean terminatedCleanly = server.shutdown()
        .awaitTermination(shutdownTimeout.getQuantity(), shutdownTimeout.getUnit());
    if (!terminatedCleanly) {
      server.shutdown();
    }
  }
}

