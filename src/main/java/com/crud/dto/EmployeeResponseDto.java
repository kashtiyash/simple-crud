package com.crud.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String email;
    private String designation;
}
