package com.extrade.connect.preparator;

import java.util.Map;

public interface MessagePreparator {
    String prepare(String templateName, Map<String,Object> tokens);
}
