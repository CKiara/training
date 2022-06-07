package com.example.grpcserver.config.grpc;

import static com.google.common.base.Preconditions.checkNotNull;

import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import java.io.File;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class DropwizardServerBuilder extends ServerBuilder<DropwizardServerBuilder> {

  private final Environment environment;
  private final ServerBuilder serverBuilder;
  private final Duration shutdownPeriod;

  public DropwizardServerBuilder(final Environment environment, final ServerBuilder<?> serverBuilder,
      final Duration shutdownPeriod) {
    this.environment = checkNotNull(environment, "Environment is null");
    this.serverBuilder = checkNotNull(serverBuilder, "ServerBuilder is null");
    this.shutdownPeriod = checkNotNull(shutdownPeriod, "ShutdownPeriod is null");
  }

  @Override
  public DropwizardServerBuilder directExecutor() {
    serverBuilder.directExecutor();
    return this;
  }

  @Override
  public DropwizardServerBuilder executor(@Nullable final Executor executor) {
    serverBuilder.executor(executor);
    return this;
  }

  @Override
  public DropwizardServerBuilder addService(final ServerServiceDefinition service) {
    serverBuilder.addService(service);
    return this;
  }

  @Override
  public DropwizardServerBuilder addService(final BindableService bindableService) {
    serverBuilder.addService(bindableService);
    return this;
  }

  @Override
  public DropwizardServerBuilder intercept(final ServerInterceptor interceptor) {
    serverBuilder.intercept(interceptor);
    return this;
  }

  @Override
  public DropwizardServerBuilder addTransportFilter(final ServerTransportFilter filter) {
    serverBuilder.addTransportFilter(filter);
    return this;
  }

  @Override
  public DropwizardServerBuilder addStreamTracerFactory(final ServerStreamTracer.Factory factory) {
    serverBuilder.addStreamTracerFactory(factory);
    return this;
  }

  @Override
  public DropwizardServerBuilder fallbackHandlerRegistry(
      @Nullable final HandlerRegistry fallbackRegistry) {
    serverBuilder.fallbackHandlerRegistry(fallbackRegistry);
    return this;
  }

  @Override
  public DropwizardServerBuilder useTransportSecurity(final File certChain, final File privateKey) {
    serverBuilder.useTransportSecurity(certChain, privateKey);
    return this;
  }

  @Override
  public DropwizardServerBuilder decompressorRegistry(
      @Nullable final DecompressorRegistry registry) {
    serverBuilder.decompressorRegistry(registry);
    return this;
  }

  @Override
  public DropwizardServerBuilder compressorRegistry(@Nullable final CompressorRegistry registry) {
    serverBuilder.compressorRegistry(registry);
    return this;
  }

  @Override
  public Server build() {
    Server server = serverBuilder.build();
    environment.lifecycle().manage(new ManagedGrpcServer(server, shutdownPeriod));
    return server;
  }
}

