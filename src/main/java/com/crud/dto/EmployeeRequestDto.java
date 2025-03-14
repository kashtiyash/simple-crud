package com.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    @NotBlank(message = "First name cannot be blank.")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank.")
    private String lastName;

    @NotNull(message = "Salary should not be empty.")
    @Positive(message = "Salary must be greater than 0.")
    private Double salary;

    @Email(message = "Add a valid email address.")
    @NotBlank(message = "Email cannot be empty.")
    private String email;

    @NotBlank(message = "Designation cannot be empty.")
    private String designation;
}
