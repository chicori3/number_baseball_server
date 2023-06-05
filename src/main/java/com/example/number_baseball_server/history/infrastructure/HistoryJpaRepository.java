package com.example.number_baseball_server.history.infrastructure;

import com.example.number_baseball_server.history.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryJpaRepository extends JpaRepository<History, Long> {

    List<History> findAllByRoomId(Long roomId);
}
