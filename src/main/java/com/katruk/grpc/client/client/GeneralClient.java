package com.katruk.grpc.client.client;

import io.grpc.StatusRuntimeException;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface GeneralClient {

    default <T, R> Optional<R> tryToDo(final T request, Function<T, R> function, Consumer<StatusRuntimeException> logger) {
        try {
            return Optional.of(function.apply(request));
        } catch (StatusRuntimeException e) {
            logger.accept(e);
            return Optional.empty();
        }
    }

}