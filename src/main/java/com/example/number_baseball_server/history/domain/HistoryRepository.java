package com.example.number_baseball_server.history.domain;

import java.util.List;

public interface HistoryRepository {

    Long save(History history);

    List<History> findAllByRoomId(Long roomId);
}
