package com.example.number_baseball_server.game.infrastructure.persistence;

import com.example.number_baseball_server.game.domain.exception.NotFoundGameException;
import com.example.number_baseball_server.game.domain.model.BaseballGame;
import com.example.number_baseball_server.game.domain.repository.BaseballGameRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BaseballGameRepositoryAdapter implements BaseballGameRepository {

    private final BaseballGameJpaRepository baseballGameRepository;

    public BaseballGameRepositoryAdapter(BaseballGameJpaRepository baseballGameJpaRepository) {
        this.baseballGameRepository = baseballGameJpaRepository;
    }

    @Override
    public Long save(BaseballGame baseballGame) {
        return baseballGameRepository.save(baseballGame).getId();
    }

    @Override
    public BaseballGame findById(Long roomId) {
        return baseballGameRepository.findById(roomId)
                .orElseThrow(NotFoundGameException::new);
    }
}
