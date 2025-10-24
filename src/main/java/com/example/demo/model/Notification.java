package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class Notification {
    private int id;
    private int emergencyId;
    private String message;
    private List<String> recipients;
    private Date timestamp;

    public Notification() {}

    public Notification(int id, int emergencyId, String message, List<String> recipients, Date timestamp) {
        this.id = id;
        this.emergencyId = emergencyId;
        this.message = message;
        this.recipients = recipients;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmergencyId() { return emergencyId; }
    public void setEmergencyId(int emergencyId) { this.emergencyId = emergencyId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public List<String> getRecipients() { return recipients; }
    public void setRecipients(List<String> recipients) { this.recipients = recipients; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}