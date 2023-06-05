package com.example.number_baseball_server.game.presentation.response;

public record GameResultResponse(int remainingCount, int answerCount) {

    public GameResultResponse(int count) {
        this(count, 10 - count);
    }
}
