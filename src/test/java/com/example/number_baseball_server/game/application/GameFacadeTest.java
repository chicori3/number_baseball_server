package com.example.number_baseball_server.game.application;

import com.example.number_baseball_server.game.application.command.GameAnswerCommand;
import com.example.number_baseball_server.game.application.command.GameCommandManager;
import com.example.number_baseball_server.game.application.query.GameQueryManager;
import com.example.number_baseball_server.game.domain.factory.NumbersGenerator;
import com.example.number_baseball_server.game.presentation.response.GameAnswerResponse;
import com.example.number_baseball_server.game.presentation.response.GameResultResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;

class GameFacadeTest {

    private GameFacade gameFacade;

    @BeforeEach
    void setUp() {
        final StubRepository repository = new StubRepository();
        final GameCommandManager gameCommandManager = new GameCommandManager(repository);
        final GameQueryManager gameQueryManager = new GameQueryManager(repository);
        final NumbersGenerator numbersGenerator = length -> List.of(1, 2, 3);

        gameFacade = new GameFacade(
                gameCommandManager,
                gameQueryManager,
                numbersGenerator,
                mock(ApplicationEventPublisher.class));
    }

    @Test
    void 게임생성() {
        assertThatCode(() -> gameFacade.create())
                .doesNotThrowAnyException();
    }

    @Test
    void 게임진행() {
        gameFacade.create();

        final GameAnswerCommand command = new GameAnswerCommand(1L, "123");
        final GameAnswerResponse gameResultResponse = gameFacade.guess(command);

        assertThat(gameResultResponse.strike()).isBetween(0, 3);
        assertThat(gameResultResponse.ball()).isBetween(0, 3);
        assertThat(gameResultResponse.out()).isBetween(0, 3);
        assertThat(gameResultResponse.remainingCount()).isEqualTo(9);
    }

    @Test
    void 게임결과() {
        gameFacade.create();

        final GameAnswerCommand command = new GameAnswerCommand(1L, "123");
        gameFacade.guess(command);
        final GameResultResponse gameResultResponse = gameFacade.result(1L);

        assertThat(gameResultResponse.remainingCount()).isEqualTo(9);
        assertThat(gameResultResponse.answerCount()).isEqualTo(1);
    }
}