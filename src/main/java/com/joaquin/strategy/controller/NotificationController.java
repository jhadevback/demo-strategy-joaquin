package com.joaquin.strategy.controller;

import com.joaquin.strategy.exception.NotFoundNotificationStrategy;
import com.joaquin.strategy.service.NotificationContext;
import com.joaquin.strategy.service.NotificationType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NotificationController {
    private final NotificationContext notificationContext;

    public NotificationController(NotificationContext notificationContext) {
        this.notificationContext = notificationContext;
    }

    @GetMapping
    public String sendNotification(@RequestParam String message,
                                   @RequestParam NotificationType notificationType) throws NotFoundNotificationStrategy {
        notificationContext.sendMessage(message, notificationType);
        return message;
    }
}
