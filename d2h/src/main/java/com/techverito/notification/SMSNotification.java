package com.techverito.notification;

public class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("SMS sent");
    }
}
