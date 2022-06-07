package com.example.training.grpc.accountservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: account-service.proto")
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.training.grpc.accountservice.AccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty,
      com.example.training.grpc.accountservice.AccountResponse> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAll",
      requestType = com.example.training.grpc.accountservice.Empty.class,
      responseType = com.example.training.grpc.accountservice.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty,
      com.example.training.grpc.accountservice.AccountResponse> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty, com.example.training.grpc.accountservice.AccountResponse> getFindAllMethod;
    if ((getFindAllMethod = AccountServiceGrpc.getFindAllMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getFindAllMethod = AccountServiceGrpc.getFindAllMethod) == null) {
          AccountServiceGrpc.getFindAllMethod = getFindAllMethod = 
              io.grpc.MethodDescriptor.<com.example.training.grpc.accountservice.Empty, com.example.training.grpc.accountservice.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.example.training.grpc.accountservice.AccountService", "findAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("findAll"))
                  .build();
          }
        }
     }
     return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty,
      com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> getFindAllByStateAndAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAllByStateAndAverage",
      requestType = com.example.training.grpc.accountservice.Empty.class,
      responseType = com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty,
      com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> getFindAllByStateAndAverageMethod() {
    io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.Empty, com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> getFindAllByStateAndAverageMethod;
    if ((getFindAllByStateAndAverageMethod = AccountServiceGrpc.getFindAllByStateAndAverageMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getFindAllByStateAndAverageMethod = AccountServiceGrpc.getFindAllByStateAndAverageMethod) == null) {
          AccountServiceGrpc.getFindAllByStateAndAverageMethod = getFindAllByStateAndAverageMethod = 
              io.grpc.MethodDescriptor.<com.example.training.grpc.accountservice.Empty, com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.example.training.grpc.accountservice.AccountService", "findAllByStateAndAverage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("findAllByStateAndAverage"))
                  .build();
          }
        }
     }
     return getFindAllByStateAndAverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.NewAccount,
      com.example.training.grpc.accountservice.AccountResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create",
      requestType = com.example.training.grpc.accountservice.NewAccount.class,
      responseType = com.example.training.grpc.accountservice.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.NewAccount,
      com.example.training.grpc.accountservice.AccountResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<com.example.training.grpc.accountservice.NewAccount, com.example.training.grpc.accountservice.AccountResponse> getCreateMethod;
    if ((getCreateMethod = AccountServiceGrpc.getCreateMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getCreateMethod = AccountServiceGrpc.getCreateMethod) == null) {
          AccountServiceGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<com.example.training.grpc.accountservice.NewAccount, com.example.training.grpc.accountservice.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.example.training.grpc.accountservice.AccountService", "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.NewAccount.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.training.grpc.accountservice.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }

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
    public void findAll(com.example.training.grpc.accountservice.Empty request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findAllByStateAndAverage(com.example.training.grpc.accountservice.Empty request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllByStateAndAverageMethod(), responseObserver);
    }

    /**
     */
    public void create(com.example.training.grpc.accountservice.NewAccount request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.training.grpc.accountservice.Empty,
                com.example.training.grpc.accountservice.AccountResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindAllByStateAndAverageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.training.grpc.accountservice.Empty,
                com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse>(
                  this, METHODID_FIND_ALL_BY_STATE_AND_AVERAGE)))
          .addMethod(
            getCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.training.grpc.accountservice.NewAccount,
                com.example.training.grpc.accountservice.AccountResponse>(
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
    public void findAll(com.example.training.grpc.accountservice.Empty request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByStateAndAverage(com.example.training.grpc.accountservice.Empty request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAllByStateAndAverageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create(com.example.training.grpc.accountservice.NewAccount request,
        io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
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
    public java.util.Iterator<com.example.training.grpc.accountservice.AccountResponse> findAll(
        com.example.training.grpc.accountservice.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse findAllByStateAndAverage(com.example.training.grpc.accountservice.Empty request) {
      return blockingUnaryCall(
          getChannel(), getFindAllByStateAndAverageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.training.grpc.accountservice.AccountResponse create(com.example.training.grpc.accountservice.NewAccount request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse> findAllByStateAndAverage(
        com.example.training.grpc.accountservice.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAllByStateAndAverageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.training.grpc.accountservice.AccountResponse> create(
        com.example.training.grpc.accountservice.NewAccount request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
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
          serviceImpl.findAll((com.example.training.grpc.accountservice.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_STATE_AND_AVERAGE:
          serviceImpl.findAllByStateAndAverage((com.example.training.grpc.accountservice.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountBalanceAverageByStateResponse>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((com.example.training.grpc.accountservice.NewAccount) request,
              (io.grpc.stub.StreamObserver<com.example.training.grpc.accountservice.AccountResponse>) responseObserver);
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

  private static abstract class AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.training.grpc.accountservice.AccountServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountService");
    }
  }

  private static final class AccountServiceFileDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier {
    AccountServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServiceMethodDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
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
              .setSchemaDescriptor(new AccountServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getFindAllByStateAndAverageMethod())
              .addMethod(getCreateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
