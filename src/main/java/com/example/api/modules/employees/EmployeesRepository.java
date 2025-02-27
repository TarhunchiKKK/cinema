package com.example.api.modules.employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

}
