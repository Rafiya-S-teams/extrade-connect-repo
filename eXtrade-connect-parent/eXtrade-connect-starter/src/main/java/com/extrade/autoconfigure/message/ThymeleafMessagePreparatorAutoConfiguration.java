package com.extrade.autoconfigure.message;

import com.extrade.connect.preparator.MessagePreparator;
import com.extrade.connect.preparator.ThymeleafMessagePreparatorImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ConditionalOnClass({TemplateMode.class, SpringTemplateEngine.class})
@AutoConfigureAfter(ThymeleafAutoConfiguration.class)
public class ThymeleafMessagePreparatorAutoConfiguration {

    @Bean
    public ThymeleafMessagePreparatorImpl thymeleafMessagePreparator(TemplateEngine templateEngine){
        ThymeleafMessagePreparatorImpl thymeleafMessagePreparator=new ThymeleafMessagePreparatorImpl(templateEngine);
        return thymeleafMessagePreparator;
    }
}
