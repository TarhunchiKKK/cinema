package com.example.api.modules.visitors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.visitors.dtos.ToggleVisitorSeansRequest;
import com.example.api.modules.visitors.services.VisitorsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/visitors")
@RequiredArgsConstructor
public class VisitorsController {
    private final VisitorsService visitorsService;

    @PatchMapping("/toggle-seans")
    public ResponseEntity<Void> toggleSeans(@RequestBody ToggleVisitorSeansRequest request) {
        this.visitorsService.toggleSeans(request);
        return ResponseEntity.accepted().build();
    }
}
