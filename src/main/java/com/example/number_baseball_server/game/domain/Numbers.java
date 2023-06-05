package com.example.number_baseball_server.game.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Numbers {

    private List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public GameResult compare(final List<Integer> inputNumbers, final int count) {
        final int strike = calculateStrikeCount(inputNumbers);
        final int ball = calculateBallCount(inputNumbers) - strike;
        final int out = 3 - strike - ball;

        return new GameResult(strike == 3, count, strike, ball, out);
    }

    private int calculateBallCount(final List<Integer> inputNumbers) {
        return (int) numbers.stream()
                .filter(inputNumbers::contains)
                .count();
    }

    private int calculateStrikeCount(final List<Integer> inputNumbers) {
        int strike = 0;

        for (int index = 0; index < inputNumbers.size(); index++) {
            if (numbers.get(index).equals(inputNumbers.get(index))) {
                strike++;
            }
        }

        return strike;
    }
}
