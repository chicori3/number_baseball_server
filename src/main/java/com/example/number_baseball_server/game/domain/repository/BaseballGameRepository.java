package com.example.number_baseball_server.game.domain.repository;

import com.example.number_baseball_server.game.domain.model.BaseballGame;

public interface BaseballGameRepository {

    Long save(BaseballGame baseballGame);

    BaseballGame findById(Long roomId);
}
