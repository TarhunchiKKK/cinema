package com.example.api.modules.auth.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorSignUpRequest {
    @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Size(min = 8, max = 255, message = "Длина пароля должна быть не более 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;

    @NotBlank(message = "Введите ФИО")
    @Size(min = 3, message = "Введите ФИО")
    private String fio;

    @NotBlank(message = "Укажите возраст")
    @Min(value = 6, message = "Возраст должен быть не менее 6 лет")
    @Max(value = 100, message = "Возраст не может быть больше 100 лет")
    private Integer age;
}
