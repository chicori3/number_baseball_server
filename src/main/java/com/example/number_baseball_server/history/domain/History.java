package com.example.number_baseball_server.history.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;

    private String answer;

    @Embedded
    private Result result;

    @Builder
    public History(final Long roomId, final String answer, final Result result) {
        this.roomId = roomId;
        this.answer = answer;
        this.result = result;
    }
}
