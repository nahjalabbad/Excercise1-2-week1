package org.example.lab5_exercise2.Controller;

import jakarta.validation.Valid;
import org.example.lab5_exercise2.API.ApiResponse;
import org.example.lab5_exercise2.Model.ProjectTracker;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/projecttracker")
public class ProjectTrackerController {

    ArrayList<ProjectTracker> trackers=new ArrayList<>();

    @GetMapping()
    public ResponseEntity getTrackers(){
        return ResponseEntity.status(200).body(trackers);
    }

    @PostMapping("/add")
    public ResponseEntity addProject(@RequestBody @Valid ProjectTracker tracker, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        if (!tracker.getStatus().matches("^(Not Started|In Progress|Completed)$")) {
            return ResponseEntity.status(400).body("Invalid status. Status must be 'Not Started', 'In Progress', or 'Completed'.");
        }
        trackers.add(tracker);
        return ResponseEntity.status(200).body(new ApiResponse("Project added succcessfully"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteProject(@PathVariable int index){
        trackers.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Project deleted successfully"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateProject(@PathVariable int index, @RequestBody @Valid ProjectTracker tracker,Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        trackers.set(index,tracker);
        return ResponseEntity.status(200).body(new ApiResponse("Project updated successfully"));
    }

    @PutMapping("/status/{id}")
    public ResponseEntity changeStatus(@PathVariable int id, @RequestParam @Valid String status){
        if (!status.matches("^(Not Started|In Progress|Completed)$")) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid status, must type Not Started, In Progress or Completed"));
        }
        for (ProjectTracker t:trackers){
            if (t.getId()==id){
                t.setStatus(status);
                return ResponseEntity.status(200).body(new ApiResponse("Status has been changed"));

            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
        }

    @GetMapping("/search/{title}")
    public ResponseEntity searchProject(@PathVariable String title){

            for (ProjectTracker t:trackers){
                if (t.getTitle().equalsIgnoreCase(title)) {
                    return ResponseEntity.status(200).body(t);
                }
            } return ResponseEntity.status(400).body(new ApiResponse("Title not found"));
    }

    @GetMapping("/displayall/{companyName}")
    public ResponseEntity displayAll(@PathVariable String companyName){
        ArrayList<ProjectTracker> sameCompany=new ArrayList<>();
            for (ProjectTracker t:trackers){
                if (t.getCompanyName().equalsIgnoreCase(companyName)){
                    sameCompany.add(t);
                }
            }
            if (sameCompany.isEmpty()){
                return ResponseEntity.status(400).body(new ApiResponse("No project found under this company name"));
            }


        return ResponseEntity.status(200).body(sameCompany);
    }

}
