package com.example.number_baseball_server.common.exception;

public enum ErrorCode {
    NOT_REMAINED_COUNT("남은 횟수가 없습니다."),
    NOT_FOUND_GAME("해당 게임을 찾을 수 없습니다."),
    CLOSED_GAME("해당 게임은 종료되었습니다.");

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
