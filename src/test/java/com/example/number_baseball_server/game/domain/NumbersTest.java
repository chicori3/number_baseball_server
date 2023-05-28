package com.example.number_baseball_server.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class NumbersTest {


    @Test
    void generate() {
        Numbers numbers = new Numbers();

        assertThatCode(() -> numbers.generateNumbers())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("모두 스트라이크인 경우")
    void compareThenAllStrike() {
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Numbers numbers = new Numbers(inputNumbers);

        Result result = numbers.compare(inputNumbers);

        assertThat(result.strike()).isEqualTo(3);
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.out()).isEqualTo(0);
    }

    @Test
    @DisplayName("모두 볼인 경우")
    void compareThenAllBall() {
        List<Integer> inputNumbers = List.of(3, 2, 1);
        Numbers numbers = new Numbers(List.of(1, 3, 2));

        Result result = numbers.compare(inputNumbers);

        assertThat(result.strike()).isEqualTo(0);
        assertThat(result.ball()).isEqualTo(3);
        assertThat(result.out()).isEqualTo(0);
    }

    @Test
    @DisplayName("모두 아웃인 경우")
    void compareThenAllOut() {
        List<Integer> inputNumbers = List.of(4, 5, 6);
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        Result result = numbers.compare(inputNumbers);

        assertThat(result.strike()).isEqualTo(0);
        assertThat(result.ball()).isEqualTo(0);
        assertThat(result.out()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크 1개, 볼 1개, 아웃 1개인 경우")
    void compareThenOneOneOne() {
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Numbers numbers = new Numbers(List.of(1, 4, 2));

        Result result = numbers.compare(inputNumbers);

        assertThat(result.strike()).isEqualTo(1);
        assertThat(result.ball()).isEqualTo(1);
        assertThat(result.out()).isEqualTo(1);
    }
}


