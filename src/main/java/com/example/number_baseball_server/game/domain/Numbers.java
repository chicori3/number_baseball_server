package com.example.number_baseball_server.game.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

@Embeddable
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void generateNumbers() {
        SecureRandom random = new SecureRandom();
        this.numbers = IntStream.generate(() -> random.nextInt(9) + 1)
                .distinct()
                .limit(3)
                .boxed()
                .toList();
    }

    public Result compare(List<Integer> inputNumbers) {
        int strike = calculateStrikeCount(inputNumbers);
        int ball = calculateBallCount(inputNumbers) - strike;
        int out = 3 - strike - ball;

        return new Result(strike, ball, out);
    }

    private int calculateBallCount(List<Integer> inputNumbers) {
        return (int) numbers.stream()
                .filter(inputNumbers::contains)
                .count();
    }

    private int calculateStrikeCount(List<Integer> inputNumbers) {
        int strike = 0;

        for (int index = 0; index < inputNumbers.size(); index++) {
            if (numbers.get(index).equals(inputNumbers.get(index))) {
                strike++;
            }
        }

        return strike;
    }
}
