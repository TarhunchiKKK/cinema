package com.example.api.modules.auth.dtos;

import com.example.api.modules.auth.entties.Profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
    private Profile profile;

    private String token;
}
