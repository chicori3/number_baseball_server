package com.example.number_baseball_server.game.application.command;

import com.example.number_baseball_server.game.domain.model.BaseballGame;
import com.example.number_baseball_server.game.domain.model.Numbers;
import com.example.number_baseball_server.game.domain.repository.BaseballGameRepository;
import org.springframework.stereotype.Component;

@Component
public class GameCommandManager {

    private final BaseballGameRepository baseballGameRepository;

    public GameCommandManager(BaseballGameRepository baseballGameRepository) {
        this.baseballGameRepository = baseballGameRepository;
    }

    public Long create(Numbers numbers) {
        BaseballGame baseballGame = new BaseballGame(numbers);

        return baseballGameRepository.save(baseballGame);
    }
}
