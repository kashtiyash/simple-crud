package com.crud.services;

import com.crud.dto.EmployeeRequestDto;
import com.crud.dto.EmployeeResponseDto;
import com.crud.exceptiions.ResourceNotFoundException;
import com.crud.models.Employee;
import com.crud.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponseDto findById(UUID id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(value -> modelMapper
                        .map(value, EmployeeResponseDto.class)).collect(Collectors.toList());
    }

    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        employee.setCreatedAt(LocalDateTime.now());
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeResponseDto.class);
    }

    public void deleteById(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    public EmployeeResponseDto update(UUID id, EmployeeRequestDto employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id));
        if (existingEmployee != null) {
            existingEmployee.setDesignation(employee.getDesignation());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            employeeRepository.save(existingEmployee);
            return modelMapper.map(existingEmployee, EmployeeResponseDto.class);
        }
        return null;
    }

}
