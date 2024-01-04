package com.joaquin.strategy.service;

import com.joaquin.strategy.exception.NotFoundNotificationStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class NotificationContext {

    private final Map<NotificationType, NotificationStrategy> sendNotificationByType;

    public NotificationContext(Map<NotificationType, NotificationStrategy> sendNotificationByType) {
        this.sendNotificationByType = sendNotificationByType;
    }

    public void sendMessage(String message, NotificationType notificationType) throws NotFoundNotificationStrategy {

        NotificationStrategy notificationStrategy = sendNotificationByType.getOrDefault(notificationType, null);

        if (Objects.isNull(notificationStrategy)) {
            throw new NotFoundNotificationStrategy("Notification Type not found. type: " + notificationType);
        }
        notificationStrategy.sendMessage(message);

    }

}
