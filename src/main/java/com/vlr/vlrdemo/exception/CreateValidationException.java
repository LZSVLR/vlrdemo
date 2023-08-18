package com.vlr.vlrdemo.exception;

public class CreateValidationException extends RuntimeException {
    public CreateValidationException() {
    }

    public CreateValidationException(String message) {
        super(message);
    }

    public CreateValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateValidationException(Throwable cause) {
        super(cause);
    }

    public CreateValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
