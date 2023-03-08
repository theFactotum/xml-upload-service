package com.task.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
public class OperationFailedException extends RuntimeException {
    public OperationFailedException(String message) {
        super(message);
    }

}
