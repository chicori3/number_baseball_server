package com.example.number_baseball_server.game.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BaseballGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    @Embedded
    private Numbers numbers;

    public BaseballGame(final Numbers numbers) {
        Assert.notNull(numbers, "숫자는 필수입니다.");

        this.count = 10;
        this.numbers = numbers;
    }

    public GameResult guess(List<Integer> inputNumbers) {
        decreaseCount();
        return numbers.compare(inputNumbers, count);
    }

    private void decreaseCount() {
        if (count == 0) {
            throw new NotRemainedCountException();
        }
        this.count--;
    }
}
