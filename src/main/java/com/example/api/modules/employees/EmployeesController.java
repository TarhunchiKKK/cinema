package com.example.api.modules.employees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.employees.dtos.ToggleEmployeeSeansRequest;
import com.example.api.modules.employees.services.EmployeesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @PatchMapping("/toggle-seans")
    public ResponseEntity<Void> toggleSeans(@RequestBody ToggleEmployeeSeansRequest request) {
        this.employeesService.toggleSeans(request);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
