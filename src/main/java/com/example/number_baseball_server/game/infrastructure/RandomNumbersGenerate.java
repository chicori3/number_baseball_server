package com.example.number_baseball_server.game.infrastructure;

import com.example.number_baseball_server.game.domain.factory.NumbersGenerator;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

public class RandomNumbersGenerate implements NumbersGenerator {

    @Override
    public List<Integer> generate(final int length) {
        SecureRandom random = new SecureRandom();
        return IntStream.generate(() -> random.nextInt(9) + 1)
                .distinct()
                .limit(length)
                .sorted()
                .boxed()
                .toList();
    }
}
