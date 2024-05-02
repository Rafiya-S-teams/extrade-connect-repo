package com.extrade.connect.manager;

import com.extrade.connect.beans.message.MailMessage;
import com.extrade.connect.beans.message.Message;
import com.extrade.connect.beans.notification.MailNotification;
import com.extrade.connect.beans.notification.Notification;
import com.extrade.connect.preparator.MessagePreparator;
import com.extrade.connect.service.MailMessageServiceImpl;
import com.extrade.connect.service.TextMessageServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class DefaultNotificationManagerImpl implements NotificationManager{

    private final MessagePreparator messagePreparator;
    private final TextMessageServiceImpl textMessageService;
    private final MailMessageServiceImpl mailMessageService;

    @Override
    public void text(Notification notification) {
        Message message=null;
        String processedMessage=null;

        processedMessage=messagePreparator.prepare(notification.getTemplateName(),notification.getTokens());
        message=new Message();
        message.setFrom(notification.getFrom());
        message.setTo(notification.getTo());
        message.setText(processedMessage);
        log.info("disaptching the message to:{} using textMessageService",message.getTo());

        textMessageService.dispatch(message);
    }

    @Override
    public void email(MailNotification mailNotification) {
        MailMessage mailMessage=new MailMessage();
        String processedMessage=null;

        processedMessage=messagePreparator.prepare(mailNotification.getTemplateName(),mailNotification.getTokens());
        mailMessage.setFrom(mailNotification.getFrom());
        mailMessage.setTo(mailNotification.getTo());
        mailMessage.setSubject(mailNotification.getSubject());
        mailMessage.setText(processedMessage);
        mailMessage.setAttachments(mailNotification.getAttachments());
        log.info("disaptching the message to:{} using mailMessageService",mailMessage.getTo());

        mailMessageService.dispatch(mailMessage);
    }
}
