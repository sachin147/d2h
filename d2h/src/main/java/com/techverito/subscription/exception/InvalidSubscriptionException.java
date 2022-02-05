package com.techverito.subscription.exception;

public class InvalidSubscriptionException extends RuntimeException {
    public InvalidSubscriptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
