package org.example.lab5_exercise2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {

    @NotEmpty(message = "Title Cannot be empty")
    @Size(min = 8,message = "Title Length must be more than 8")
    private String title;

    @NotEmpty(message = "Description Cannot be empty")
    @Size(min=15)
    private String description;

    @NotEmpty(message = "Company Name Cannot be empty")
    @Size(min=6)
    private String companyName;

    @NotNull
    @Min(2)
    private int id;
    @NotEmpty(message = "Status Cannot be empty")
    @Pattern(regexp ="^(Not Started|In Progress|Completed)$")
    private String status;
}
