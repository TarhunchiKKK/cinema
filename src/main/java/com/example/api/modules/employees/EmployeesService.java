package com.example.api.modules.employees;

import org.springframework.stereotype.Service;

import com.example.api.modules.employees.dtos.CreateEmployeeRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public Employee create(CreateEmployeeRequest request) {
        return this.employeesRepository.save(
                new Employee(request.getFio(), request.getPost(), request.getExperience(), request.getProfile()));
    }
}
