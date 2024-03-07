package org.example.task_tracker.Controller;

import org.example.task_tracker.API.ApiResponse;
import org.example.task_tracker.Model.TaskTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/taskt")
public class TaskTrackerController {
ArrayList<TaskTracker> trackers=new ArrayList<>();

@PostMapping("/add")
public ApiResponse addTask(@RequestBody TaskTracker tracker){
trackers.add(tracker);
return new ApiResponse("Task Added successfully.");
}

@GetMapping()
public ArrayList<TaskTracker> getTrackers(){
    return trackers;
}


@PutMapping("/update/{index}")
public ApiResponse updateTask(@PathVariable int index, @RequestBody TaskTracker tracker){
    try {
        trackers.set(index,tracker);
        return new ApiResponse("Task Updated successfully.");
    }catch (IndexOutOfBoundsException e){
        return new ApiResponse("index out of bound");
    }

}


@DeleteMapping("/delete/{index}")
public ApiResponse deleteTask(@PathVariable int index){
    try {
        trackers.remove(index);
        return new ApiResponse("Task Deleted successfully.");
    }catch (IndexOutOfBoundsException e){
        return new ApiResponse("index out of bound");
    }

}

@PutMapping("/change/{ID}")
public ApiResponse changeStatus(@PathVariable int ID){
    for (TaskTracker tracker1:trackers){
        if (tracker1.getID()==ID&&Objects.equals(tracker1.getStatus(), "not done")){
            tracker1.setStatus("done");
            return new ApiResponse("Status changed.");
        }
        else if (tracker1.getID()==ID&&Objects.equals(tracker1.getStatus(), "done")){
            return new ApiResponse("The status is already marked as Done");
        }
    }
    return new ApiResponse("ID not found.");
}

@GetMapping("/search/{title}")
public ApiResponse getTask(@PathVariable String title){
    for (TaskTracker tracker:trackers){
        if (Objects.equals(tracker.getTitle(), title)){
            String task=tracker.toString();
            return new ApiResponse(task);


        }
    }
    return new ApiResponse("Task not found");
}
}
