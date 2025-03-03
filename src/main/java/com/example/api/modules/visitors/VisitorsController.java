package com.example.api.modules.visitors;

import com.example.api.modules.employees.entities.Employee;
import com.example.api.modules.visitors.entities.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.api.modules.visitors.dtos.ToggleVisitorSeansRequest;
import com.example.api.modules.visitors.services.VisitorsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/visitors")
@RequiredArgsConstructor
public class VisitorsController {
    private final VisitorsService visitorsService;

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> findByProfileId(@PathVariable("id") Long profileId) {
        return new ResponseEntity<Visitor>(this.visitorsService.findByProfileId(profileId), HttpStatus.OK) ;
    }

    @PatchMapping("/toggle-seans")
    public ResponseEntity<Void> toggleSeans(@RequestBody ToggleVisitorSeansRequest request) {
        this.visitorsService.toggleSeans(request);
        return ResponseEntity.accepted().build();
    }
}
