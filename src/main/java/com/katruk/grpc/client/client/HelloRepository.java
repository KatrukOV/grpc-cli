package com.katruk.grpc.client.client;

import com.katruk.grpc.client.client.pb.Hello;
import com.katruk.grpc.client.client.pb.HelloApiGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
@Component
public class HelloRepository implements RetryRpc, GeneralClient {

    private static final int DEAD_LINE_TIME = 50;
    private static final int TRIES = 3;

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

    public Optional<Hello.HelloResponse> trySay(final String name) throws RuntimeException {
        Function<String, Hello.HelloResponse> action = e -> this.blockingStub
                .withDeadlineAfter(DEAD_LINE_TIME, MILLISECONDS)
                .trySay(Hello.HelloRequest.newBuilder()
                        .setName(e)
                        .build()
                );
        Function<String, Hello.HelloResponse> retry = e -> retry(name, action, TRIES);
        Consumer<StatusRuntimeException> logger = e -> log.warn(e.getMessage());
        return tryToDo(name, retry, logger);
    }

    public Optional<Hello.HelloResponse> cfSay(final String name) throws RuntimeException {
        return Optional.of(
                this.blockingStub
                        .withDeadlineAfter(DEAD_LINE_TIME, MILLISECONDS)
                        .cfSay(Hello.HelloRequest.newBuilder()
                                .setName(name)
                                .build()
                        )
        );
    }

}
