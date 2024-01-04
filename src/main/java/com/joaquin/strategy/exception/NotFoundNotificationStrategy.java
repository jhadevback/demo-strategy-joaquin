package com.joaquin.strategy.exception;

public class NotFoundNotificationStrategy extends RuntimeException {
    public NotFoundNotificationStrategy(String message) {
        super(message);
    }
}
