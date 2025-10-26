package com.example.demo.model;

import java.time.LocalDateTime;

public class Emergency {
    private int id;
    private String type;
    private String location;
    private String severity;
    private String status;
    private String reportedBy;

    private LocalDateTime reportedAt;

    public Emergency() {}

    public Emergency(int id, String type, String location, String severity, String status, String reportedBy) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.severity = severity;
        this.status = status;
        this.reportedBy = reportedBy;
        this.reportedAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public LocalDateTime getReportedAt() { return reportedAt; }
    public void setReportedAt(LocalDateTime reportedAt) { this.reportedAt = reportedAt;}

}