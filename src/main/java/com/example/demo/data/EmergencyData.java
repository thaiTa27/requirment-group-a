package com.example.demo.data;

import java.util.*;

public class EmergencyData {

    //in memory list
    private static final List<Map<String, Object>> emergencies = new ArrayList<>();

    static {
        Map<String, Object> e1 = new HashMap<>();
        e1.put("id", 1);
        e1.put("type", "Fire");
        e1.put("location", "Building 80, Level 3");
        e1.put("severity", "High");
        e1.put("status", "Active");
        e1.put("reportedBy", "Sensor-203");
        emergencies.add(e1);

        Map<String, Object> e2 = new HashMap<>();
        e2.put("id", 2);
        e2.put("type", "Gas Leak");
        e2.put("location", "Building 14, Basement");
        e2.put("severity", "Medium");
        e2.put("status", "Active");
        e2.put("reportedBy", "Sensor-102");
        emergencies.add(e2);


        Map<String, Object> e3 = new HashMap<>();
        e3.put("id", 3);
        e3.put("type", "Medical");
        e3.put("location", "Building 12, Level 2");
        e3.put("severity", "Low");
        e3.put("status", "Resolved");
        e3.put("reportedBy", "AppUser-45");
        emergencies.add(e3);

        Map<String, Object> e4 = new HashMap<>();
        e4.put("id", 4);
        e4.put("type", "Security Breach");
        e4.put("location", "Building 2, Entrance Gate");
        e4.put("severity", "Critical");
        e4.put("status", "Active");
        e4.put("reportedBy", "Camera-55");
        emergencies.add(e4);
    }

    // Return the emergency list
    public static List<Map<String, Object>> getEmergencies() {
        return emergencies;
    }
}