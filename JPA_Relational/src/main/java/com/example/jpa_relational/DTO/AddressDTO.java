package com.example.jpa_relational.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "teacher id cannot be null")
    private Integer teacher_id;

    @NotEmpty(message = "area cannot be null")
    private String area;

    @NotEmpty(message = "street cannot be null")
    private String street;

    @NotNull(message = "building number cannot be null")
    private Integer buildingNumber;
}
