package com.help_desk.demo.exception;

public class AtendenteException extends RuntimeException {
    public AtendenteException(String message) {
        super(message);
    }
    public AtendenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
