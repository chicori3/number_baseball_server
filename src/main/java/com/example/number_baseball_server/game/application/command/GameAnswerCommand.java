package com.example.number_baseball_server.game.application.command;

import java.util.List;

public record GameAnswerCommand(Long roomId, String answer) {
    public List<Integer> answerToList() {
        return List.of(answer.split("")).stream()
                .map(Integer::parseInt)
                .toList();
    }
}
