package com.hotel.notifications;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[SMS SENT]: " + message);
    }
}