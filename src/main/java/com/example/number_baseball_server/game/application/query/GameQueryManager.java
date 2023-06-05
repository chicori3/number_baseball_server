package com.example.number_baseball_server.game.application.query;

import com.example.number_baseball_server.game.domain.model.BaseballGame;
import com.example.number_baseball_server.game.domain.repository.BaseballGameRepository;
import org.springframework.stereotype.Component;

@Component
public class GameQueryManager {

    private final BaseballGameRepository baseballGameRepository;

    public GameQueryManager(final BaseballGameRepository baseballGameRepository) {
        this.baseballGameRepository = baseballGameRepository;
    }

    public BaseballGame findById(final Long roomId) {
        return baseballGameRepository.findById(roomId);
    }
}
