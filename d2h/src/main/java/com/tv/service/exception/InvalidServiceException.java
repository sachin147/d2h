package com.techverito.service.exception;

public class InvalidServiceException extends RuntimeException {
    public InvalidServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
