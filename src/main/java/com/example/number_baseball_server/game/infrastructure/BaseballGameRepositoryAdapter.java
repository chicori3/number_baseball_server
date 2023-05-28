package com.example.number_baseball_server.game.infrastructure;

import com.example.number_baseball_server.game.domain.BaseballGame;
import com.example.number_baseball_server.game.domain.BaseballGameRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BaseballGameRepositoryAdapter implements BaseballGameRepository {

    private final BaseballGameJpaRepository baseballGameRepository;

    public BaseballGameRepositoryAdapter(BaseballGameJpaRepository baseballGameJpaRepository) {
        this.baseballGameRepository = baseballGameJpaRepository;
    }

    @Override
    public Long save(BaseballGame baseballGame) {
        return baseballGameRepository.save(baseballGame).getRoomId();
    }

    @Override
    public BaseballGame findById(Long roomId) {
        return baseballGameRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 방이 없습니다."));
    }
}
