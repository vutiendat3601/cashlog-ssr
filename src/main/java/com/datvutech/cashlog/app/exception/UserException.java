package com.datvutech.cashlog.app.exception;

public class UserException extends RuntimeException {
    public static final String USER_NOT_FOUND = "USER NOT FOUND";
    public static final String USER_DUPLICATION = "USER DUPLICATION";

    public UserException(String message) {
        super(message);
    }
}
