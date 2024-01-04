package com.joaquin.strategy.service;

public interface NotificationStrategy {
    void sendMessage(String message);
    NotificationType notificationType();
}
