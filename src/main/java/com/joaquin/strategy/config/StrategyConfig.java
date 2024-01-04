package com.joaquin.strategy.config;

import com.joaquin.strategy.service.NotificationStrategy;
import com.joaquin.strategy.service.NotificationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
public class StrategyConfig {

    private final List<NotificationStrategy> notificationStrategies;

    public StrategyConfig(List<NotificationStrategy> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    @Bean
    public Map<NotificationType, NotificationStrategy> sendNotificationByType(){

        Map<NotificationType, NotificationStrategy> messagesByType = new EnumMap<>(NotificationType.class);

        notificationStrategies.forEach(notificationStrategy -> {
            messagesByType.put(notificationStrategy.notificationType(), notificationStrategy);
        });

        return messagesByType;

    }

}
