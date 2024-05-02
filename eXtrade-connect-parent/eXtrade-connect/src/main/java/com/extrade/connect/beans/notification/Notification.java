package com.extrade.connect.beans.notification;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
public class Notification {
    private String from;
    private String[] to;
    private String templateName;
    private Map<String, Object> tokens;
}
