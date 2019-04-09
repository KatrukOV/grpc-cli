package com.katruk.grpc.client.client.pb;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.19.0)",
        comments = "Source: hello.proto")
public final class HelloApiGrpc {

    public static final String SERVICE_NAME = "grpc.client.HelloApi";
    private static final int METHODID_TRY_SAY = 0;
    private static final int METHODID_CF_SAY = 1;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest,
            com.katruk.grpc.client.client.pb.Hello.HelloResponse> getTrySayMethod;
    private static volatile io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest,
            com.katruk.grpc.client.client.pb.Hello.HelloResponse> getCfSayMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private HelloApiGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "trySay",
            requestType = com.katruk.grpc.client.client.pb.Hello.HelloRequest.class,
            responseType = com.katruk.grpc.client.client.pb.Hello.HelloResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest,
            com.katruk.grpc.client.client.pb.Hello.HelloResponse> getTrySayMethod() {
        io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest, com.katruk.grpc.client.client.pb.Hello.HelloResponse> getTrySayMethod;
        if ((getTrySayMethod = HelloApiGrpc.getTrySayMethod) == null) {
            synchronized (HelloApiGrpc.class) {
                if ((getTrySayMethod = HelloApiGrpc.getTrySayMethod) == null) {
                    HelloApiGrpc.getTrySayMethod = getTrySayMethod =
                            io.grpc.MethodDescriptor.<com.katruk.grpc.client.client.pb.Hello.HelloRequest, com.katruk.grpc.client.client.pb.Hello.HelloResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "grpc.client.HelloApi", "trySay"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.katruk.grpc.client.client.pb.Hello.HelloRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.katruk.grpc.client.client.pb.Hello.HelloResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new HelloApiMethodDescriptorSupplier("trySay"))
                                    .build();
                }
            }
        }
        return getTrySayMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "cfSay",
            requestType = com.katruk.grpc.client.client.pb.Hello.HelloRequest.class,
            responseType = com.katruk.grpc.client.client.pb.Hello.HelloResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest,
            com.katruk.grpc.client.client.pb.Hello.HelloResponse> getCfSayMethod() {
        io.grpc.MethodDescriptor<com.katruk.grpc.client.client.pb.Hello.HelloRequest, com.katruk.grpc.client.client.pb.Hello.HelloResponse> getCfSayMethod;
        if ((getCfSayMethod = HelloApiGrpc.getCfSayMethod) == null) {
            synchronized (HelloApiGrpc.class) {
                if ((getCfSayMethod = HelloApiGrpc.getCfSayMethod) == null) {
                    HelloApiGrpc.getCfSayMethod = getCfSayMethod =
                            io.grpc.MethodDescriptor.<com.katruk.grpc.client.client.pb.Hello.HelloRequest, com.katruk.grpc.client.client.pb.Hello.HelloResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "grpc.client.HelloApi", "cfSay"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.katruk.grpc.client.client.pb.Hello.HelloRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.katruk.grpc.client.client.pb.Hello.HelloResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new HelloApiMethodDescriptorSupplier("cfSay"))
                                    .build();
                }
            }
        }
        return getCfSayMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static HelloApiStub newStub(io.grpc.Channel channel) {
        return new HelloApiStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static HelloApiBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new HelloApiBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static HelloApiFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new HelloApiFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (HelloApiGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new HelloApiFileDescriptorSupplier())
                            .addMethod(getTrySayMethod())
                            .addMethod(getCfSayMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class HelloApiImplBase implements io.grpc.BindableService {

        /**
         */
        public void trySay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request,
                           io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getTrySayMethod(), responseObserver);
        }

        /**
         */
        public void cfSay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request,
                          io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCfSayMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getTrySayMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.katruk.grpc.client.client.pb.Hello.HelloRequest,
                                            com.katruk.grpc.client.client.pb.Hello.HelloResponse>(
                                            this, METHODID_TRY_SAY)))
                    .addMethod(
                            getCfSayMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.katruk.grpc.client.client.pb.Hello.HelloRequest,
                                            com.katruk.grpc.client.client.pb.Hello.HelloResponse>(
                                            this, METHODID_CF_SAY)))
                    .build();
        }
    }

    /**
     */
    public static final class HelloApiStub extends io.grpc.stub.AbstractStub<HelloApiStub> {
        private HelloApiStub(io.grpc.Channel channel) {
            super(channel);
        }

        private HelloApiStub(io.grpc.Channel channel,
                             io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloApiStub build(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            return new HelloApiStub(channel, callOptions);
        }

        /**
         */
        public void trySay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request,
                           io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getTrySayMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void cfSay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request,
                          io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCfSayMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class HelloApiBlockingStub extends io.grpc.stub.AbstractStub<HelloApiBlockingStub> {
        private HelloApiBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private HelloApiBlockingStub(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloApiBlockingStub build(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            return new HelloApiBlockingStub(channel, callOptions);
        }

        /**
         */
        public com.katruk.grpc.client.client.pb.Hello.HelloResponse trySay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request) {
            return blockingUnaryCall(
                    getChannel(), getTrySayMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.katruk.grpc.client.client.pb.Hello.HelloResponse cfSay(com.katruk.grpc.client.client.pb.Hello.HelloRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCfSayMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class HelloApiFutureStub extends io.grpc.stub.AbstractStub<HelloApiFutureStub> {
        private HelloApiFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private HelloApiFutureStub(io.grpc.Channel channel,
                                   io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloApiFutureStub build(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            return new HelloApiFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.katruk.grpc.client.client.pb.Hello.HelloResponse> trySay(
                com.katruk.grpc.client.client.pb.Hello.HelloRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getTrySayMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.katruk.grpc.client.client.pb.Hello.HelloResponse> cfSay(
                com.katruk.grpc.client.client.pb.Hello.HelloRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCfSayMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final HelloApiImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(HelloApiImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_TRY_SAY:
                    serviceImpl.trySay((com.katruk.grpc.client.client.pb.Hello.HelloRequest) request,
                            (io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse>) responseObserver);
                    break;
                case METHODID_CF_SAY:
                    serviceImpl.cfSay((com.katruk.grpc.client.client.pb.Hello.HelloRequest) request,
                            (io.grpc.stub.StreamObserver<com.katruk.grpc.client.client.pb.Hello.HelloResponse>) responseObserver);
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

    private static abstract class HelloApiBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        HelloApiBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.katruk.grpc.client.client.pb.Hello.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("HelloApi");
        }
    }

    private static final class HelloApiFileDescriptorSupplier
            extends HelloApiBaseDescriptorSupplier {
        HelloApiFileDescriptorSupplier() {
        }
    }

    private static final class HelloApiMethodDescriptorSupplier
            extends HelloApiBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        HelloApiMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
