package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecordAlreadyExistException extends RuntimeException {
    public RecordAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public RecordAlreadyExistException(String message) {
        super(message);
    }

}

