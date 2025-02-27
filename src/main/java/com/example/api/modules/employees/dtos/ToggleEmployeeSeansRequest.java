package com.example.api.modules.employees.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToggleEmployeeSeansRequest {
    private Long seansId;
}
