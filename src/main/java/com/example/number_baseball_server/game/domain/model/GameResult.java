package com.example.number_baseball_server.game.domain.model;


public record GameResult(boolean correct, int remainingCount, int strike, int ball, int out) {
}
