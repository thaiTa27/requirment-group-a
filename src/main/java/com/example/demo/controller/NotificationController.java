package com.example.demo.controller;

import com.example.demo.data.EmergencyData;
import com.example.demo.data.NotificationData;
import com.example.demo.model.Emergency;
import com.example.demo.model.Notification;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    // In-memory storage for notifications
//    private final List<Notification> notifications = new ArrayList<>();

    private final List<Notification> notifications = NotificationData.getNotifications();

    //  sent notification to sender
    @PostMapping
    public Map<String, Object> sendNotification(@RequestBody Notification newNotification) {
        int newId = notifications.size() + 1;
        newNotification.setId(newId);
        newNotification.setTimestamp(new Date());
        notifications.add(newNotification);

        return Map.of(
                "message", "Notification sent successfully",
                "notificationId", newId,
                "sentTo", newNotification.getRecipients()
        );
    }

    //  get all notification
    @GetMapping
    public Map<String, Object> getAllNotifications() {
        return Map.of("notifications", notifications);
    }
}