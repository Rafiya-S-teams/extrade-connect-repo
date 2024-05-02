package com.extrade.connect.preparator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@AllArgsConstructor
@Slf4j
public class ThymeleafMessagePreparatorImpl implements MessagePreparator{
    private TemplateEngine templateEngine;

    @Override
    public String prepare(String templateName, Map<String, Object> tokens) {
        if(log.isDebugEnabled()){
            log.debug("preparing the message for the template {}",templateName);
        }
        Context context=new Context();
        tokens.forEach((k,v)->{
            context.setVariable(k,v);
        });
        return templateEngine.process(templateName,context);
    }
}
