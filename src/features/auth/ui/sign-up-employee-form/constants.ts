import { TSignUpEmployeeDto } from "@/entities/profiles";
import { TFormField } from "@/shared/types";

export const defaultValues: TSignUpEmployeeDto = {
    email: "",
    password: "",
    fio: "",
    post: "",
    experience: 2
};

export const formFields: TFormField<TSignUpEmployeeDto>[] = [
    {
        name: "email",
        label: "Email",
        type: "email",
        placeholder: "Введите email"
    },
    {
        name: "password",
        label: "Пароль",
        type: "password",
        placeholder: "Введите пароль"
    },
    {
        name: "fio",
        label: "ФИО",
        type: "text",
        placeholder: "Введите ФИО"
    },
    {
        name: "post",
        label: "Должность",
        type: "text",
        placeholder: "Введите должность"
    },
    {
        name: "experience",
        label: "Опыт работы",
        type: "number",
        placeholder: "Введите опыт работы в годах"
    }
];
