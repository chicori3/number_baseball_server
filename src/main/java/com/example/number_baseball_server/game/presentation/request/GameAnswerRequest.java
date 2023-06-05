package com.example.number_baseball_server.game.presentation.request;

import org.springframework.util.Assert;

public record GameAnswerRequest(String answer) {
    public GameAnswerRequest {
        Assert.hasText(answer, "정답 입력은 필수입니다.");
    }
}
