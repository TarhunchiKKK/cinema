package com.example.api.modules.auth.dtos;

import com.example.api.modules.auth.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String email;

    private String password;

    private Role role;
}
