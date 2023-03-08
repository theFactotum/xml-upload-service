package com.task.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class RecordAlreadyExistException extends RuntimeException {
    public RecordAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public RecordAlreadyExistException(String message) {
        super(message);
    }

}

