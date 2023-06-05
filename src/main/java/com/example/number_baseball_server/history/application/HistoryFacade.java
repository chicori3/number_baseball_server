package com.example.number_baseball_server.history.application;

import com.example.number_baseball_server.history.application.query.HistoryQueryManager;
import org.springframework.stereotype.Service;

@Service
public class HistoryFacade {

    private final HistoryQueryManager historyQueryManager;

    public HistoryFacade(final HistoryQueryManager historyQueryManager) {
        this.historyQueryManager = historyQueryManager;
    }
}
