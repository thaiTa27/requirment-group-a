package com.example.demo.controller;//package com.rmit.smartresponse.controller;

import com.example.demo.data.EmergencyData;
import com.example.demo.model.Emergency;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {

    private final List<Emergency> emergencies = EmergencyData.getEmergencies();


    //get all emege
    @GetMapping
    public Map<String, Object> getAllEmergencies() {
        return Map.of("emergencies", emergencies);
    }

    @PostMapping
    public Map<String, Object> reportEmergency(@RequestBody Emergency newEmergency) {
        int newId = emergencies.size() + 1;
        newEmergency.setId(newId);
        newEmergency.setStatus("Active");
        emergencies.add(newEmergency);

        return Map.of("message", "Emergency reported successfully", "id", newId);
    }

    @GetMapping("/{id}")
    public Object getEmergencyById(@PathVariable int id) {
        return emergencies.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse( (Emergency) Map.of("error", "Emergency not found"));
    }
}