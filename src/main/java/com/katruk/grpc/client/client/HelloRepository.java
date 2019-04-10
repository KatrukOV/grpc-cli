package com.katruk.grpc.client.client;

import com.katruk.grpc.client.client.pb.Hello;
import com.katruk.grpc.client.client.pb.HelloApiGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
@Component
public class HelloRepository implements RetryRpc {

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
        Function<String, Hello.HelloResponse> commit = e -> this.blockingStub
                .withDeadlineAfter(DEAD_LINE_TIME, MILLISECONDS)
                .trySay(Hello.HelloRequest.newBuilder()
                        .setName(e)
                        .build()
                );
        try {
            return retry(name, commit, TRIES);
        } catch (StatusRuntimeException e) {
            return catchException(e);
        }
    }

    public Optional<Hello.HelloResponse> cfSay(final String name) throws RuntimeException {
        try {
            return Optional.of(
                    this.blockingStub
                            .withDeadlineAfter(DEAD_LINE_TIME, MILLISECONDS)
                            .cfSay(Hello.HelloRequest.newBuilder()
                                    .setName(name)
                                    .build()
                            )
            );
        } catch (StatusRuntimeException e) {
            return catchException(e);
        }
    }

    private Optional<Hello.HelloResponse> catchException(StatusRuntimeException e) {
        if (e.getStatus().getCode().equals(Status.Code.UNKNOWN)) {
            log.error("UNKNOWN: {}", e.getMessage());
            return Optional.empty();
        }
        if (e.getStatus().getCode().equals(Status.Code.ABORTED)) {
            log.warn("ABORTED: {}", e.getMessage());
            return Optional.empty();
        }
        if (e.getStatus().getCode().equals(Status.Code.DEADLINE_EXCEEDED)) {
            log.warn("DEADLINE_EXCEEDED: {}", e.getMessage());
            return Optional.empty();
        }
        throw e;
    }

}
