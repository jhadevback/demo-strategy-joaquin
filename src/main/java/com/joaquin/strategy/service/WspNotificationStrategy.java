package com.joaquin.strategy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WspNotificationStrategy implements NotificationStrategy{
    @Override
    public void sendMessage(String message) {
        log.info("message send to phone" + message);
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.WHATSAPP;
    }
}
