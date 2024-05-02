package com.extrade.autoconfigure.message;

import com.extrade.connect.service.TextMessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextMessageServiceAutoConfiguration {

    @Bean
    public TextMessageServiceImpl textMessageService(){
        return new TextMessageServiceImpl();
    }
}
