package com.example.number_baseball_server.game.domain.exception;

import com.example.number_baseball_server.common.exception.ErrorCode;
import com.example.number_baseball_server.common.exception.SystemException;

public class NotFoundGameException extends SystemException {

    public NotFoundGameException() {
        super(ErrorCode.CLOSED_GAME);
    }
}
