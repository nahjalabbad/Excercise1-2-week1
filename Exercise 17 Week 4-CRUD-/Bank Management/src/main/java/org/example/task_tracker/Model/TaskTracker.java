package org.example.task_tracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskTracker {
        private String title,description,status;
        private int ID;

}
