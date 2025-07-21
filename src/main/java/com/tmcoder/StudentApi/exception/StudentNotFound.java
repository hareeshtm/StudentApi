package com.tmcoder.StudentApi.exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound() {
        super();
    }

    public StudentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StudentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFound(String message) {
        super(message);
    }

    public StudentNotFound(Throwable cause) {
        super(cause);
    }
}
