package com.example.demo.data;

import com.example.demo.model.Emergency;
import java.util.*;

public class EmergencyData {

    private static final List<Emergency> emergencies = new ArrayList<>();

    static {
        emergencies.add(new Emergency(1, "Fire", "Building 80, Level 3", "High", "Active", "Sensor-203"));
        emergencies.add(new Emergency(2, "Gas Leak", "Building 14, Basement", "Medium", "Active", "Sensor-102"));
        emergencies.add(new Emergency(3, "Medical", "Building 12, Level 2", "Low", "Resolved", "AppUser-45"));
        emergencies.add(new Emergency(4, "Security Breach", "Building 2, Entrance Gate", "Critical", "Active", "Camera-55"));
    }

    public static List<Emergency> getEmergencies() {
        return emergencies;
    }
}