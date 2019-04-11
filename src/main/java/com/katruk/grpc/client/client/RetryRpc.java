package com.katruk.grpc.client.client;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public abstract class RetryRpc {

    public <T, R> R retry(T request, Function<T, R> action, final int tries) throws StatusRuntimeException {
        String message = "";
        for (int i = 1; i <= tries; i++) {
            try {
                log.info("T {} for {}", i, request);
                return action.apply(request);
            } catch (Exception e) {
                message = String.format("Can't receive after %d tries with error %s", tries, e.getMessage());
            }
        }
        throw Status.ABORTED.withDescription(message).asRuntimeException();
    }

}