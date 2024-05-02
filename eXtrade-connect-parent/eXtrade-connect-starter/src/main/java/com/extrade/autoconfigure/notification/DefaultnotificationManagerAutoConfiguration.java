package com.extrade.autoconfigure.notification;

import com.extrade.autoconfigure.message.MailMessageServiceAutoConfiguration;
import com.extrade.autoconfigure.message.TextMessageServiceAutoConfiguration;
import com.extrade.autoconfigure.message.ThymeleafMessagePreparatorAutoConfiguration;
import com.extrade.connect.manager.DefaultNotificationManagerImpl;
import com.extrade.connect.preparator.ThymeleafMessagePreparatorImpl;
import com.extrade.connect.service.MailMessageServiceImpl;
import com.extrade.connect.service.TextMessageServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({ThymeleafMessagePreparatorAutoConfiguration.class, TextMessageServiceAutoConfiguration.class, MailMessageServiceAutoConfiguration.class})
public class DefaultnotificationManagerAutoConfiguration {

    @Bean
    public DefaultNotificationManagerImpl defaultNotificationManager(ThymeleafMessagePreparatorImpl thymeleafMessagePreparator, TextMessageServiceImpl textMessageService, MailMessageServiceImpl mailMessageService){
        return new DefaultNotificationManagerImpl(thymeleafMessagePreparator,textMessageService,mailMessageService);
    }
}
