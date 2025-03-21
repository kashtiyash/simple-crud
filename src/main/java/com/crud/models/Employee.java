package com.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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

    private LocalDateTime createdAt;
}
