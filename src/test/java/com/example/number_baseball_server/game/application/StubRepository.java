package com.example.number_baseball_server.game.application;

import com.example.number_baseball_server.game.domain.model.BaseballGame;
import com.example.number_baseball_server.game.domain.repository.BaseballGameRepository;

import java.util.HashMap;
import java.util.Map;


public class StubRepository implements BaseballGameRepository {

    private Map<Long, BaseballGame> persistence = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Long save(final BaseballGame baseballGame) {
        persistence.put(++sequence, baseballGame);
        return sequence;
    }

    @Override
    public BaseballGame findById(final Long roomId) {
        return persistence.get(roomId);
    }

}
