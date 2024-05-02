package com.extrade.connect.beans.message;

import lombok.Builder;
import lombok.Data;

@Data
public class Message {
    private String from;
    private String[] to;
    private String text;
}
