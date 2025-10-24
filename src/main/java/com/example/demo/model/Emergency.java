package com.example.demo.model;

public class Emergency {
    private int id;
    private String type;
    private String location;
    private String severity;
    private String status;
    private String reportedBy;

    public Emergency() {}

    public Emergency(int id, String type, String location, String severity, String status, String reportedBy) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.severity = severity;
        this.status = status;
        this.reportedBy = reportedBy;
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
}