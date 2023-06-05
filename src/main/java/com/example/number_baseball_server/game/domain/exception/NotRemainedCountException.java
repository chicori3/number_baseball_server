package com.example.number_baseball_server.game.domain.exception;

import com.example.number_baseball_server.common.exception.ErrorCode;
import com.example.number_baseball_server.common.exception.SystemException;

public class NotRemainedCountException extends SystemException {

    public NotRemainedCountException() {
        super(ErrorCode.CLOSED_GAME);
    }

    public NotRemainedCountException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
