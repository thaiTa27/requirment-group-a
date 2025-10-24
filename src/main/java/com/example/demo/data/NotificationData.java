package com.example.demo.data;

import com.example.demo.model.Notification;

import java.util.*;

public class NotificationData {

    private static final List<Notification> notifications = new ArrayList<>();

    static {
        notifications.add(
                new Notification(
                        1,
                        2,
                        "Gas leak detected in Building 14, Basement. Fire department notified.",
                        Arrays.asList("FireDept", "SecurityTeam"),
                        new Date()
                )
        );
    }

    public static List<Notification> getNotifications() {
        return notifications;
    }
}