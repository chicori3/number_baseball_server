package com.example.number_baseball_server.common.exception;

import com.example.number_baseball_server.common.response.Response;
import com.example.number_baseball_server.game.domain.exception.NotFoundGameException;
import com.example.number_baseball_server.game.domain.exception.NotRemainedCountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            NotRemainedCountException.class,
            NotFoundGameException.class
    })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Response<ErrorCode, String> handleNotRemainedCountException(SystemException e) {
        return Response.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<Exception, String> handleException(Exception e) {
        return Response.fail(e, e.getMessage());
    }
}
