package com.extrade.connect.beans;

import lombok.Data;

@Data
public class Attachment {
    private String filename;
    private byte[] contents;
    private String mediaType;
    private AttachmentType attachmentType;

}
