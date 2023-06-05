package com.example.number_baseball_server.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@JsonInclude(Include.NON_NULL)
public class Response<T, R> {

    private final boolean success;
    private final T data;
    private R message;

    private Response(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private Response(boolean success, T data, R message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> Response<T, Void> success(T data) {
        return new Response<>(true, data);
    }

    public static <T, R> Response<T, R> fail(T data, R message) {
        return new Response<>(false, data, message);
    }
}

