package com.example.api.modules.halls.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHallRequest {
    @NotBlank(message = "укажите тип зала")
    private String type;

    @NotBlank(message = "укажите кол-во мест")
    @Positive(message = "кол-во мест не может быть меньше 1")
    private Integer seatsCount;
}
