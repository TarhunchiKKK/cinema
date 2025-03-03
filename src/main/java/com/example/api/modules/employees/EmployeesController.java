package com.example.api.modules.employees;

import com.example.api.modules.employees.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.api.modules.employees.dtos.ToggleEmployeeSeansRequest;
import com.example.api.modules.employees.services.EmployeesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findByProfileId(@PathVariable("id") Long profileId) {
        return new ResponseEntity<Employee>(this.employeesService.findByProfileId(profileId), HttpStatus.OK) ;
    }

    @PatchMapping("/toggle-seans")
    public ResponseEntity<Void> toggleSeans(@RequestBody ToggleEmployeeSeansRequest request) {
        this.employeesService.toggleSeans(request);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
