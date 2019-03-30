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

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
@Component
public class HelloRepository {
    private static final int DEAD_LINE_TIME = 1500;
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
        try {
            return this.blockingStub
                    .withDeadlineAfter(DEAD_LINE_TIME, MILLISECONDS)
                    .say(request);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode().equals(Status.Code.UNKNOWN)) {
                log.info("UNKNOWN: {}", e.getMessage());
                return Hello.HelloResponse.newBuilder().build();
            }
            if (e.getStatus().getCode().equals(Status.Code.DEADLINE_EXCEEDED)) {
                log.info("DEADLINE_EXCEEDED: {}", e.getMessage());
                return Hello.HelloResponse.newBuilder().build();
            }
            throw e;
        }

    }

}
