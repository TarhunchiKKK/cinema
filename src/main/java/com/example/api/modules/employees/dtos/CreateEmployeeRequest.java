package com.example.api.modules.employees.dtos;

import com.example.api.modules.auth.entties.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    private String fio;

    private String post;

    private Float experience;

    private Profile profile;
}
