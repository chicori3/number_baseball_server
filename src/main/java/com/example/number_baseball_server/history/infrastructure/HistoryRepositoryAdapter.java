package com.example.number_baseball_server.history.infrastructure;

import com.example.number_baseball_server.history.domain.History;
import com.example.number_baseball_server.history.domain.HistoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryRepositoryAdapter implements HistoryRepository {

    private final HistoryJpaRepository historyJpaRepository;

    public HistoryRepositoryAdapter(final HistoryJpaRepository historyJpaRepository) {
        this.historyJpaRepository = historyJpaRepository;
    }

    @Override
    public Long save(final History history) {
        return historyJpaRepository.save(history).getId();
    }

    @Override
    public List<History> findAllByRoomId(final Long roomId) {
        return historyJpaRepository.findAllByRoomId(roomId);
    }
}
