package com.example.demo.controller;//package com.rmit.smartresponse.controller;

import com.example.demo.data.EmergencyData;
import com.example.demo.model.Emergency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getEmergencyById(@PathVariable int id) {
        Optional<Emergency> emergency = emergencies.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        if (emergency.isPresent()) {
            return ResponseEntity.ok(emergency.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Emergency not found"));
        }
    }
}