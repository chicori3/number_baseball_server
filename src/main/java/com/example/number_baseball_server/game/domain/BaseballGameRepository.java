package com.example.number_baseball_server.game.domain;

public interface BaseballGameRepository {

    Long save(BaseballGame baseballGame);

    BaseballGame findById(Long roomId);
}
