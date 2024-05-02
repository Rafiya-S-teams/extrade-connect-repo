package com.extrade.connect.service;

import com.extrade.connect.beans.message.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextMessageServiceImpl implements MessageService{

    @Override
    public void dispatch(Message message) {
        log.info("Sending an text message to: {} with body: {}",message.getTo(),message.getText());
    }
}
