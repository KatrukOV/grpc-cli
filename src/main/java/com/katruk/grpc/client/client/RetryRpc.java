package com.katruk.grpc.client.client;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import java.util.Optional;
import java.util.function.Function;

public interface RetryRpc {

    default <T, R> Optional<R> retry(T request, Function<T, R> commit, final int tries) throws StatusRuntimeException {
        String message = "";
        for (int i = 1; i <= tries; i++) {
            try {
                return Optional.of(commit.apply(request));
            } catch (Exception e) {
                message = String.format("Can't receive after %d tries with error %s", tries, e.getMessage());
            }
        }
        throw Status.ABORTED.withDescription(message).asRuntimeException();
    }

}