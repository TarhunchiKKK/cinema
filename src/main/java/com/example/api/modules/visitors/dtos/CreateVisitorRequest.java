package com.example.api.modules.visitors.dtos;

import com.example.api.modules.auth.entties.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVisitorRequest {
    private String fio;

    private Integer age;

    private Profile profile;
}
