package com.extrade;

import com.extrade.service.UserRegistrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.spring6.ISpringTemplateEngine;

import java.io.IOException;

@SpringBootApplication
public class ExtradeApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext context= SpringApplication.run(ExtradeApplication.class,args);
        UserRegistrationService service=context.getBean(UserRegistrationService.class);

        service.register("Harry");
    }

}
