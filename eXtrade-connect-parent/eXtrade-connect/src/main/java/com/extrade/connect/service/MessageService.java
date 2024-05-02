package com.extrade.connect.service;

import com.extrade.connect.beans.message.Message;

public interface MessageService<T extends Message>{
    void dispatch(final T message);
}
