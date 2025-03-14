package com.crud.services;

import com.crud.models.Employee;
import com.crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Employee employee) {
        Employee existingEmployee = findById(employee.getId());
        if (existingEmployee != null) {
            existingEmployee.setDesignation(employee.getDesignation());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }


}
