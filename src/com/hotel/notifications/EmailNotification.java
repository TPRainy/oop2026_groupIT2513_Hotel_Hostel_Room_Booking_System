package com.hotel.notifications;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[EMAIL SENT]: " + message);
    }
}