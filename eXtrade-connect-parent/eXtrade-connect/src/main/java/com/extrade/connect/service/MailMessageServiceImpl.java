package com.extrade.connect.service;

import com.extrade.connect.beans.AttachmentType;
import com.extrade.connect.beans.InlineAttachment;
import com.extrade.connect.beans.message.MailMessage;
import com.extrade.connect.beans.message.Message;
import com.extrade.connect.exception.MailMessageAttachmentsFailedException;
import jakarta.mail.MessagingException;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@AllArgsConstructor
@Slf4j
public class MailMessageServiceImpl implements MessageService<MailMessage>{
   private JavaMailSender javaMailSender;
    @Override
    public void dispatch(final MailMessage message) {
        log.info("in dispatch()");

        javaMailSender.send(mimeMessage -> {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(message.getFrom());
            mimeMessageHelper.setTo(message.getTo());
            mimeMessageHelper.setSubject(message.getSubject());
            mimeMessageHelper.setText(message.getText(),true);

            if(message.getAttachments()!=null && !message.getAttachments().isEmpty()){
                message.getAttachments().forEach(attachment -> {
                    if (attachment.getAttachmentType()== AttachmentType.ATTACHMENT){
                        try {
                            mimeMessageHelper.addAttachment(attachment.getFilename(),
                                    new ByteArrayDataSource(attachment.getContents(), attachment.getMediaType()));
                        } catch (MessagingException e) {
                            throw new MailMessageAttachmentsFailedException("Unable to add the attachment",e);
                        }
                    }else if(attachment.getAttachmentType()==AttachmentType.INLINE){
                        try {
                            mimeMessageHelper.addInline(((InlineAttachment)attachment).getCid(),new ByteArrayDataSource(attachment.getContents(), attachment.getMediaType()));
                        } catch (MessagingException e) {
                            throw new MailMessageAttachmentsFailedException("Unable to add the attachment",e);
                        }
                    }
                });
            }

        });
    }
}
