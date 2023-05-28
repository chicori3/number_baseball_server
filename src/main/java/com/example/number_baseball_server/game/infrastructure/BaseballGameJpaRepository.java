package com.example.number_baseball_server.game.infrastructure;

import com.example.number_baseball_server.game.domain.BaseballGame;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseballGameJpaRepository extends JpaRepository<BaseballGame, Long> {

}
