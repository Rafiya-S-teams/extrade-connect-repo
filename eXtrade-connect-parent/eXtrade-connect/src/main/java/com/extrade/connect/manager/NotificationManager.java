package com.extrade.connect.manager;

import com.extrade.connect.beans.notification.MailNotification;
import com.extrade.connect.beans.notification.Notification;

public interface NotificationManager {
    void text(Notification notification);

    void email(MailNotification mailNotification);
}
