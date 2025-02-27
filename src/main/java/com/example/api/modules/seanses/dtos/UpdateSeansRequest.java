package com.example.api.modules.seanses.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSeansRequest {
    @NotBlank(message = "")
    private String date;

    private Float price;

    private Integer duration;
}
