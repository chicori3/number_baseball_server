package com.example.number_baseball_server.history.application.command;

import com.example.number_baseball_server.game.domain.model.BaseballGameEvent;
import com.example.number_baseball_server.history.domain.History;
import com.example.number_baseball_server.history.domain.HistoryRepository;
import com.example.number_baseball_server.history.domain.Result;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class HistoryCommandManager {

    private final HistoryRepository historyRepository;

    public HistoryCommandManager(final HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void saveHistory(BaseballGameEvent event) {
        History history = new History().builder()
                .roomId(event.getId())
                .answer(event.getAnswer())
                .result(new Result(event.getStrike(), event.getBall(), event.getOut()))
                .build();

        Long id = historyRepository.save(history);

        System.out.println(id);
    }
}
