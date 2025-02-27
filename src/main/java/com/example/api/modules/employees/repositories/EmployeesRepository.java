package com.example.api.modules.employees.repositories;

import com.example.api.modules.employees.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

}
