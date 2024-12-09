package com.help_desk.demo.exception;

public class BalcaoException extends RuntimeException {
    public BalcaoException(String message) {
        super(message);
    }
    public BalcaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
