package com.example.number_baseball_server.game.presentation.response;

import com.example.number_baseball_server.game.domain.model.GameResult;

public record GameAnswerResponse(boolean correct, int remainingCount, int strike, int ball, int out) {
    public GameAnswerResponse(GameResult result) {
        this(result.correct(), result.remainingCount(), result.strike(), result.ball(), result.out());
    }
}
