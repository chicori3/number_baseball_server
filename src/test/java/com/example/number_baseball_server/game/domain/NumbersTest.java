package com.example.number_baseball_server.game.domain;

import com.example.number_baseball_server.game.domain.factory.NumbersGenerator;
import com.example.number_baseball_server.game.domain.model.GameResult;
import com.example.number_baseball_server.game.domain.model.Numbers;
import com.example.number_baseball_server.game.infrastructure.RandomNumbersGenerate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    final int count = 10;
    NumbersGenerator numbersGenerator = new RandomNumbersGenerate();

    @Test
    void generate() {
        List<Integer> generatedNumbers = numbersGenerator.generate(3);
        Numbers numbers = new Numbers(generatedNumbers);

        assertThat(generatedNumbers.size()).isEqualTo(3);
        assertThat(numbers).isNotNull();
    }

    @Test
    @DisplayName("모두 스트라이크인 경우")
    void compareThenAllStrike() {
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Numbers numbers = new Numbers(inputNumbers);

        GameResult result = numbers.compare(inputNumbers, count);

        assertThat(result.strike()).isEqualTo(3);
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.out()).isEqualTo(0);
    }

    @Test
    @DisplayName("모두 볼인 경우")
    void compareThenAllBall() {
        List<Integer> inputNumbers = List.of(3, 2, 1);
        Numbers numbers = new Numbers(List.of(1, 3, 2));

        GameResult result = numbers.compare(inputNumbers, count);

        assertThat(result.strike()).isEqualTo(0);
        assertThat(result.ball()).isEqualTo(3);
        assertThat(result.out()).isEqualTo(0);
    }

    @Test
    @DisplayName("모두 아웃인 경우")
    void compareThenAllOut() {
        List<Integer> inputNumbers = List.of(4, 5, 6);
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        GameResult result = numbers.compare(inputNumbers, count);

        assertThat(result.strike()).isEqualTo(0);
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.out()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크 1개, 볼 1개, 아웃 1개인 경우")
    void compareThenOneOneOne() {
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Numbers numbers = new Numbers(List.of(1, 4, 2));

        GameResult result = numbers.compare(inputNumbers, count);

        assertThat(result.strike()).isEqualTo(1);
        assertThat(result.ball()).isEqualTo(1);
        assertThat(result.out()).isEqualTo(1);
    }
}


