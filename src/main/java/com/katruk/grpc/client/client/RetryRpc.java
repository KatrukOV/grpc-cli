package com.katruk.grpc.client.client;

import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public abstract class RetryRpc {

    public <T, R> R retry(T request, Function<T, R> action, final int tries, final int delay) {
        String message = "";
        for (int i = 1; i <= tries; i++) {
            try {
                log.info("T {} for {}", i, request);
                return action.apply(request);
            } catch (Exception e) {
                message = String.format("Can't receive after %d tries with error %s", tries, e.getMessage());
                try {
                    Thread.sleep(delay);
                } catch (Exception ex) {
                    log.warn("Request delay failed: {}", ex.getMessage());
                    throw Status.RESOURCE_EXHAUSTED.withDescription(ex.getMessage()).asRuntimeException();
                }
            }
        }
        throw Status.ABORTED.withDescription(message).asRuntimeException();
    }

}