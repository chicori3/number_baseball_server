package com.example.number_baseball_server.history.application.query;

import com.example.number_baseball_server.history.domain.History;
import com.example.number_baseball_server.history.domain.HistoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryQueryManager {

    private final HistoryRepository historyRepository;

    public HistoryQueryManager(final HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> findByRoomId(final Long roomId) {
        return historyRepository.findAllByRoomId(roomId);
    }
}
