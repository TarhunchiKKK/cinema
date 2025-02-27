package com.example.api.modules.auth.dtos;

import com.example.api.modules.auth.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSignUpRequest {
    @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Size(min = 8, max = 255, message = "Длина пароля должна быть не более 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;

    @NotBlank(message = "Укажите свою роль")
    private Role role;

    @NotBlank(message = "Введите ФИО")
    @Size(min = 3, message = "Введите ФИО")
    private String fio;

    private String post;

    private Float experience;
}
