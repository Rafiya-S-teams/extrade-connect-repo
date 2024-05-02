package com.extrade.connect.beans.message;

import com.extrade.connect.beans.Attachment;
import lombok.Data;

import java.util.List;

@Data
public class MailMessage extends Message{
    private String subject;
    private List<Attachment> attachments;
}
