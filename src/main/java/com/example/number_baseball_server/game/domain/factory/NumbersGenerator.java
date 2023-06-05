package com.example.number_baseball_server.game.domain.factory;

import java.util.List;

public interface NumbersGenerator {

    List<Integer> generate(int length);
}
