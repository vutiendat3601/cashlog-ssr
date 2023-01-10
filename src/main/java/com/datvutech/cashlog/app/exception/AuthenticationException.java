package com.datvutech.cashlog.app.exception;

public class AuthenticationException extends RuntimeException {
    public static final String BAD_CREDENTIALS = "Bad credentials";

    public AuthenticationException(String message) {
        super(message);
    }
}
