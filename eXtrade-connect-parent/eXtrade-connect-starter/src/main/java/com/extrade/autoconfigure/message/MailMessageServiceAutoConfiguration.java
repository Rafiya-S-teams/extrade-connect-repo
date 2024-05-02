package com.extrade.autoconfigure.message;

import com.extrade.connect.service.MailMessageServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@AutoConfigureAfter({MailSenderAutoConfiguration.class})
public class MailMessageServiceAutoConfiguration {

    @Bean
    public MailMessageServiceImpl mailMessageService(JavaMailSender javaMailSender){
        MailMessageServiceImpl mailMessageService=new MailMessageServiceImpl(javaMailSender);
        return mailMessageService;
    }

}
