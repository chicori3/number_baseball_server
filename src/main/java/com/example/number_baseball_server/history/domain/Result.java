package com.example.number_baseball_server.history.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Result {

    private int strike;
    private int ball;
    private int out;

    public Result(final int strike, final int ball, final int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }
}
