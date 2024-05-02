package com.extrade.service;

import com.extrade.connect.beans.Attachment;
import com.extrade.connect.beans.AttachmentType;
import com.extrade.connect.beans.InlineAttachment;
import com.extrade.connect.beans.notification.MailNotification;
import com.extrade.connect.manager.NotificationManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRegistrationService {
    private final NotificationManager notificationManager;
    private final String templateDir;

    public UserRegistrationService(NotificationManager notificationManager,
                                   @Value("${extrade.template.dir}") String templateDir){
        this.notificationManager=notificationManager;
        this.templateDir=templateDir;
    }

    public void register(String username) throws IOException {
        List<Attachment> attachments=null;
        byte[] image_7=null;

        image_7=new FileSystemResource(new File(templateDir+"/images/image-7.png")).getInputStream().readAllBytes();
        Attachment image_7Attachment= InlineAttachment.of().cid("image-7").build();
        image_7Attachment.setFilename("image-7.png");
        image_7Attachment.setMediaType("image/png");
        image_7Attachment.setContents(image_7);
        image_7Attachment.setAttachmentType(AttachmentType.INLINE);

        attachments=List.of(new Attachment[]{image_7Attachment});
        MailNotification notification=new MailNotification();
        notification.setAttachments(attachments);
        notification.setFrom("rafiya.cse.rymec@gmail.com");
        notification.setTo(new String[]{"rafiya.rymec.cse@gmail.com"});
        notification.setSubject("welcome to Extrade");
        notification.setTemplateName("email.html");
        Map<String,Object> tokens=new HashMap<>();
        tokens.put("user",username);
        notification.setTokens(tokens);

        notificationManager.email(notification);

    }
}
