package com.example.api.modules.employees;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;
}
