package org.example.lab5_exercise3.Controller;

import jakarta.validation.Valid;
import org.example.lab5_exercise3.API.ApiResponse;
import org.example.lab5_exercise3.Model.EventSystem;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventSystemController {
    private final ArrayList<EventSystem> events = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<ArrayList<EventSystem>> getEvents() {
        return ResponseEntity.ok().body(events);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addEvent(@RequestBody @Valid EventSystem event, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(new ApiResponse(message));
        }

        events.add(event);
        return ResponseEntity.ok().body(new ApiResponse("Event has been added successfully"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity<ApiResponse> deleteEvent(@PathVariable int index) {
        if (index >= 0 && index < events.size()) {
            events.remove(index);
            return ResponseEntity.ok().body(new ApiResponse("Event has been deleted successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("Invalid index"));
        }
    }

    @PutMapping("/update/{index}")
    public ResponseEntity<ApiResponse> updateEvent(@PathVariable int index,@RequestBody @Valid EventSystem event, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(new ApiResponse(message));
        }

        if (index >= 0 && index < events.size()) {
            events.set(index, event);
            return ResponseEntity.ok().body(new ApiResponse("Event has been updated successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("Invalid index"));
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<ApiResponse> changeCapacity(@PathVariable int id, @RequestParam int capacity) {
        for (EventSystem e : events) {
            if (e.getId() == id) {
                e.setCapacity(capacity);
                return ResponseEntity.ok().body(new ApiResponse("Capacity of " + id + " has been changed to " + capacity));
            }
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Event ID not found"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchEvent(@PathVariable int id) {
        for (EventSystem e : events) {
            if (e.getId() == id) {
                return ResponseEntity.ok().body(e);
            }
        }
        return ResponseEntity.badRequest().body(new ApiResponse("No event found with ID: " + id));
    }
}
