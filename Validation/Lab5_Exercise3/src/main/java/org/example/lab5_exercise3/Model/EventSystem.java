package org.example.lab5_exercise3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class EventSystem {
    @NotNull(message = "id cannot be null")
    @Min(2)
    private int id;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 25, message = "Capacity must be at least 25")
    private Integer capacity;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 15)
    private String description;

    @NotNull(message = "Date cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate, endDate;
}
