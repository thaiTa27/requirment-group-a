package com.example.demo.controller;

import com.example.demo.data.EmergencyData;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {

    private final List<Map<String, Object>> emergencies = EmergencyData.getEmergencies();

    // ✅ GET: Retrieve all active emergencies
    @GetMapping
    public Map<String, Object> getAllEmergencies() {
        return Map.of("emergencies", emergencies);
    }

    // ✅ POST: Report a new emergency
    @PostMapping
    public Map<String, Object> reportEmergency(@RequestBody Map<String, Object> newEmergency) {
        int newId = emergencies.size() + 1;
        newEmergency.put("id", newId);
        newEmergency.put("status", "Active");
        emergencies.add(newEmergency);

        return Map.of("message", "Emergency reported successfully", "id", newId);
    }
}