package com.example.number_baseball_server.game.infrastructure.persistence;

import com.example.number_baseball_server.game.domain.model.BaseballGame;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseballGameJpaRepository extends JpaRepository<BaseballGame, Long> {

}
