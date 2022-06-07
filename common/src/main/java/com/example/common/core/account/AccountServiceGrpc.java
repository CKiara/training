package com.example.common.core.account;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: proto/core/account/account-service.proto")
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final String SERVICE_NAME = "core.account.AccountService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.common.api.accountResponse.AccountResponse> METHOD_FIND_ALL =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.common.api.accountResponse.AccountResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "core.account.AccountService", "findAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.common.api.accountResponse.AccountResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse> METHOD_FIND_ALL_BY_STATE_AND_AVERAGE =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "core.account.AccountService", "findAllByStateAndAverage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.common.api.accountRequest.AccountRequest,
      com.example.common.api.accountResponse.AccountResponse> METHOD_CREATE =
      io.grpc.MethodDescriptor.<com.example.common.api.accountRequest.AccountRequest, com.example.common.api.accountResponse.AccountResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "core.account.AccountService", "create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.common.api.accountRequest.AccountRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.common.api.accountResponse.AccountResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    return new AccountServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ALL, responseObserver);
    }

    /**
     */
    public void findAllByStateAndAverage(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ALL_BY_STATE_AND_AVERAGE, responseObserver);
    }

    /**
     */
    public void create(com.example.common.api.accountRequest.AccountRequest request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_FIND_ALL,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.common.api.accountResponse.AccountResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            METHOD_FIND_ALL_BY_STATE_AND_AVERAGE,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse>(
                  this, METHODID_FIND_ALL_BY_STATE_AND_AVERAGE)))
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.common.api.accountRequest.AccountRequest,
                com.example.common.api.accountResponse.AccountResponse>(
                  this, METHODID_CREATE)))
          .build();
    }
  }

  /**
   */
  public static final class AccountServiceStub extends io.grpc.stub.AbstractStub<AccountServiceStub> {
    private AccountServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByStateAndAverage(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL_BY_STATE_AND_AVERAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create(com.example.common.api.accountRequest.AccountRequest request,
        io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountServiceBlockingStub extends io.grpc.stub.AbstractStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.common.api.accountResponse.AccountResponse> findAll(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_FIND_ALL, getCallOptions(), request);
    }

    /**
     */
    public com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse findAllByStateAndAverage(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_ALL_BY_STATE_AND_AVERAGE, getCallOptions(), request);
    }

    /**
     */
    public com.example.common.api.accountResponse.AccountResponse create(com.example.common.api.accountRequest.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountServiceFutureStub extends io.grpc.stub.AbstractStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse> findAllByStateAndAverage(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL_BY_STATE_AND_AVERAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.common.api.accountResponse.AccountResponse> create(
        com.example.common.api.accountRequest.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_FIND_ALL_BY_STATE_AND_AVERAGE = 1;
  private static final int METHODID_CREATE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_STATE_AND_AVERAGE:
          serviceImpl.findAllByStateAndAverage((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.common.api.accountBalanceAverageByStateResponse.AccountBalanceAverageByStateResponse>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((com.example.common.api.accountRequest.AccountRequest) request,
              (io.grpc.stub.StreamObserver<com.example.common.api.accountResponse.AccountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AccountServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.common.core.account.AccountServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceDescriptorSupplier())
              .addMethod(METHOD_FIND_ALL)
              .addMethod(METHOD_FIND_ALL_BY_STATE_AND_AVERAGE)
              .addMethod(METHOD_CREATE)
              .build();
        }
      }
    }
    return result;
  }
}
