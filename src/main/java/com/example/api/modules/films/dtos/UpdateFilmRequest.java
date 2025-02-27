package com.example.api.modules.films.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFilmRequest {
    @NotBlank(message = "Навзание фильма должно быть указано")
    private String title;

    @Min(value = 1900, message = "Год выпуска фильма не может быть меньше 1900")
    private Integer year;

    @Max(value = 2025, message = "Год выпуска фильма не может быть больше 2025")
    private String country;
}
