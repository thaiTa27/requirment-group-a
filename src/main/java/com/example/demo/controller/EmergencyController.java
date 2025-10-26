package com.example.demo.controller;//package com.rmit.smartresponse.controller;

import com.example.demo.data.EmergencyData;
import com.example.demo.model.Emergency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {

    private final List<Emergency> emergencies = EmergencyData.getEmergencies();

    @PostMapping
    public ResponseEntity<?> reportEmergency(@RequestBody Emergency newEmergency) {
        try {
//          validate missing or empty fields
            List<String> missingFields = new ArrayList<>();

            if (newEmergency.getType() == null || newEmergency.getType().isBlank()) missingFields.add("type");
            if (newEmergency.getLocation() == null || newEmergency.getLocation().isBlank()) missingFields.add("location");
            if (newEmergency.getSeverity() == null || newEmergency.getSeverity().isBlank()) missingFields.add("severity");
            if (newEmergency.getStatus() == null || newEmergency.getStatus().isBlank()) missingFields.add("status");
            if (newEmergency.getReportedBy() == null || newEmergency.getReportedBy().isBlank()) missingFields.add("reportedBy");

//            sent the message back clarify which field is empty
            if (!missingFields.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "Missing or empty field(s): " + String.join(", ", missingFields)));
            }

//          check for duplicate emergency (based on type, location, and status) this avoid duplication for all
            boolean duplicateExists = emergencies.stream().anyMatch(e ->
                    e.getType().equalsIgnoreCase(newEmergency.getType()) &&
                            e.getLocation().equalsIgnoreCase(newEmergency.getLocation()) &&
                            e.getStatus().equalsIgnoreCase(newEmergency.getStatus())
            );

            if (duplicateExists) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("error", "Duplicate emergency already exists at this location"));
            }

//           if all good then create emegercy added
            int newId = emergencies.size() + 1;
//            add the time and id
            newEmergency.setId(newId);
            newEmergency.setReportedAt(LocalDateTime.now());
            emergencies.add(newEmergency);


//            send response back to the user that it
            Map<String, Object> response = Map.of(
                    "message", "Emergency reported successfully",
                    "id", newId
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Failed to report emergency"));
        }
    }



    // get the id
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmergencyById(@PathVariable int id) {
//        lopp through emergency
        Optional<Emergency> emergency = emergencies.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        if (emergency.isPresent()) {
            return ResponseEntity.ok(emergency.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "this emergency not found id: " + id) );
        }
    }



    //this api end point to illustrate video purpose that new Emergency being added
    @GetMapping
    public List<Emergency> getAllEmergencies() {
        return emergencies;
    }


}