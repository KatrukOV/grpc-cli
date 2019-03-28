package com.katruk.grpc.cli.client;

import com.katruk.grpc.cli.client.pb.Hello;
import com.katruk.grpc.cli.client.pb.HelloApiGrpc;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class HelloRepository {
    private static final int DEAD_LINE_TIME = 2;
    private final HelloApiGrpc.HelloApiBlockingStub blockingStub;

    @Autowired
    public HelloRepository(@Value("${hello.host}") String host,
                           @Value("${hello.port}") Integer port) {
        this.blockingStub = HelloApiGrpc.newBlockingStub(
                ManagedChannelBuilder
                        .forAddress(host, port)
                        .usePlaintext()
                        .build()
        );
    }

    public Hello.HelloResponse say(final String name) throws RuntimeException {
        Hello.HelloRequest request = Hello.HelloRequest.newBuilder()
                .setName(name)
                .build();
        return this.blockingStub
                .withDeadlineAfter(DEAD_LINE_TIME, SECONDS)
                .say(request);
    }

}
