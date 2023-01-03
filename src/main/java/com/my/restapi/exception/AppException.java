package com.my.restapi.exception;

public class AppException extends RuntimeException{
    public AppException(String message) {
        super(message);
    }
}
