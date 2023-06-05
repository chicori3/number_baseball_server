package com.example.number_baseball_server.game.application;

import com.example.number_baseball_server.game.application.command.GameAnswerCommand;
import com.example.number_baseball_server.game.application.command.GameCommandManager;
import com.example.number_baseball_server.game.application.query.GameQueryManager;
import com.example.number_baseball_server.game.domain.factory.NumbersGenerator;
import com.example.number_baseball_server.game.domain.model.BaseballGame;
import com.example.number_baseball_server.game.domain.model.BaseballGameEvent;
import com.example.number_baseball_server.game.domain.model.GameResult;
import com.example.number_baseball_server.game.domain.model.Numbers;
import com.example.number_baseball_server.game.presentation.response.GameAnswerResponse;
import com.example.number_baseball_server.game.presentation.response.GameResultResponse;
import com.example.number_baseball_server.game.presentation.response.GameStartResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameFacade {

    private final GameCommandManager gameCommandManager;
    private final GameQueryManager gameQueryManager;
    private final NumbersGenerator numbersGenerator;
    private final ApplicationEventPublisher publisher;

    public GameFacade(final GameCommandManager gameCommandManager, final GameQueryManager gameQueryManager, final NumbersGenerator numbersGenerator, final ApplicationEventPublisher publisher) {
        this.gameCommandManager = gameCommandManager;
        this.gameQueryManager = gameQueryManager;
        this.numbersGenerator = numbersGenerator;
        this.publisher = publisher;
    }

    public GameStartResponse create() {
        List<Integer> numbers = numbersGenerator.generate(3);
        Long roomId = gameCommandManager.create(new Numbers(numbers));

        return new GameStartResponse(roomId);
    }

    @Transactional
    public GameAnswerResponse guess(final GameAnswerCommand command) {
        final BaseballGame baseballGame = gameQueryManager.findById(command.roomId());
        final GameResult result = baseballGame.guess(command.answerToList());

        publisher.publishEvent(new BaseballGameEvent(baseballGame.getId(), command.answer(), result));

        return new GameAnswerResponse(result);
    }

    public GameResultResponse result(final Long roomId) {
        final BaseballGame baseballGame = gameQueryManager.findById(roomId);
        final int count = baseballGame.getCount();

        return new GameResultResponse(count);
    }
}


