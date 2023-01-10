package com.datvutech.cashlog.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class WebExceptionHandler {
    @ExceptionHandler(UserException.class)
    public void handleUserException(UserException userException) {
        System.out.println(userException.getMessage());
    }
}
