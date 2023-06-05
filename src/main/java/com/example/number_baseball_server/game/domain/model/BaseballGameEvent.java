package com.example.number_baseball_server.game.domain.model;

import com.example.number_baseball_server.common.domain.DomainEvent;

public class BaseballGameEvent implements DomainEvent {

    private final Long id;
    private final String answer;
    private final GameResult result;

    public BaseballGameEvent(final Long id, final String answer, final GameResult result) {
        this.id = id;
        this.answer = answer;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public int getStrike() {
        return result.strike();
    }

    public int getBall() {
        return result.ball();
    }

    public int getOut() {
        return result.out();
    }
}
