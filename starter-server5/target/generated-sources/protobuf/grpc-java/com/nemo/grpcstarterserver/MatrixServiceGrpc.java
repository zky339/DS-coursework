package com.nemo.grpcstarterserver;

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
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: server.proto")
public final class MatrixServiceGrpc {

  private MatrixServiceGrpc() {}

  public static final String SERVICE_NAME = "server.MatrixService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest,
      com.nemo.grpcstarterserver.MatrixResponse> getMultiplyBlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multiplyBlock",
      requestType = com.nemo.grpcstarterserver.MatrixRequest.class,
      responseType = com.nemo.grpcstarterserver.MatrixResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest,
      com.nemo.grpcstarterserver.MatrixResponse> getMultiplyBlockMethod() {
    io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest, com.nemo.grpcstarterserver.MatrixResponse> getMultiplyBlockMethod;
    if ((getMultiplyBlockMethod = MatrixServiceGrpc.getMultiplyBlockMethod) == null) {
      synchronized (MatrixServiceGrpc.class) {
        if ((getMultiplyBlockMethod = MatrixServiceGrpc.getMultiplyBlockMethod) == null) {
          MatrixServiceGrpc.getMultiplyBlockMethod = getMultiplyBlockMethod =
              io.grpc.MethodDescriptor.<com.nemo.grpcstarterserver.MatrixRequest, com.nemo.grpcstarterserver.MatrixResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multiplyBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nemo.grpcstarterserver.MatrixRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nemo.grpcstarterserver.MatrixResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MatrixServiceMethodDescriptorSupplier("multiplyBlock"))
              .build();
        }
      }
    }
    return getMultiplyBlockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest,
      com.nemo.grpcstarterserver.MatrixResponse> getAddBlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addBlock",
      requestType = com.nemo.grpcstarterserver.MatrixRequest.class,
      responseType = com.nemo.grpcstarterserver.MatrixResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest,
      com.nemo.grpcstarterserver.MatrixResponse> getAddBlockMethod() {
    io.grpc.MethodDescriptor<com.nemo.grpcstarterserver.MatrixRequest, com.nemo.grpcstarterserver.MatrixResponse> getAddBlockMethod;
    if ((getAddBlockMethod = MatrixServiceGrpc.getAddBlockMethod) == null) {
      synchronized (MatrixServiceGrpc.class) {
        if ((getAddBlockMethod = MatrixServiceGrpc.getAddBlockMethod) == null) {
          MatrixServiceGrpc.getAddBlockMethod = getAddBlockMethod =
              io.grpc.MethodDescriptor.<com.nemo.grpcstarterserver.MatrixRequest, com.nemo.grpcstarterserver.MatrixResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nemo.grpcstarterserver.MatrixRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nemo.grpcstarterserver.MatrixResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MatrixServiceMethodDescriptorSupplier("addBlock"))
              .build();
        }
      }
    }
    return getAddBlockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MatrixServiceStub newStub(io.grpc.Channel channel) {
    return new MatrixServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MatrixServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MatrixServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MatrixServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MatrixServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MatrixServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void multiplyBlock(com.nemo.grpcstarterserver.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMultiplyBlockMethod(), responseObserver);
    }

    /**
     */
    public void addBlock(com.nemo.grpcstarterserver.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddBlockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMultiplyBlockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nemo.grpcstarterserver.MatrixRequest,
                com.nemo.grpcstarterserver.MatrixResponse>(
                  this, METHODID_MULTIPLY_BLOCK)))
          .addMethod(
            getAddBlockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nemo.grpcstarterserver.MatrixRequest,
                com.nemo.grpcstarterserver.MatrixResponse>(
                  this, METHODID_ADD_BLOCK)))
          .build();
    }
  }

  /**
   */
  public static final class MatrixServiceStub extends io.grpc.stub.AbstractStub<MatrixServiceStub> {
    private MatrixServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatrixServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatrixServiceStub(channel, callOptions);
    }

    /**
     */
    public void multiplyBlock(com.nemo.grpcstarterserver.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMultiplyBlockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addBlock(com.nemo.grpcstarterserver.MatrixRequest request,
        io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddBlockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MatrixServiceBlockingStub extends io.grpc.stub.AbstractStub<MatrixServiceBlockingStub> {
    private MatrixServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatrixServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatrixServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nemo.grpcstarterserver.MatrixResponse multiplyBlock(com.nemo.grpcstarterserver.MatrixRequest request) {
      return blockingUnaryCall(
          getChannel(), getMultiplyBlockMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nemo.grpcstarterserver.MatrixResponse addBlock(com.nemo.grpcstarterserver.MatrixRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddBlockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MatrixServiceFutureStub extends io.grpc.stub.AbstractStub<MatrixServiceFutureStub> {
    private MatrixServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MatrixServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MatrixServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nemo.grpcstarterserver.MatrixResponse> multiplyBlock(
        com.nemo.grpcstarterserver.MatrixRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMultiplyBlockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nemo.grpcstarterserver.MatrixResponse> addBlock(
        com.nemo.grpcstarterserver.MatrixRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddBlockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MULTIPLY_BLOCK = 0;
  private static final int METHODID_ADD_BLOCK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MatrixServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MatrixServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MULTIPLY_BLOCK:
          serviceImpl.multiplyBlock((com.nemo.grpcstarterserver.MatrixRequest) request,
              (io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse>) responseObserver);
          break;
        case METHODID_ADD_BLOCK:
          serviceImpl.addBlock((com.nemo.grpcstarterserver.MatrixRequest) request,
              (io.grpc.stub.StreamObserver<com.nemo.grpcstarterserver.MatrixResponse>) responseObserver);
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

  private static abstract class MatrixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MatrixServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nemo.grpcstarterserver.ServerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MatrixService");
    }
  }

  private static final class MatrixServiceFileDescriptorSupplier
      extends MatrixServiceBaseDescriptorSupplier {
    MatrixServiceFileDescriptorSupplier() {}
  }

  private static final class MatrixServiceMethodDescriptorSupplier
      extends MatrixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MatrixServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MatrixServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MatrixServiceFileDescriptorSupplier())
              .addMethod(getMultiplyBlockMethod())
              .addMethod(getAddBlockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
