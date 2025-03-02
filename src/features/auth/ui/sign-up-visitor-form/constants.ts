import { TSignUpVisitorDto } from "@/entities/profiles";
import { TFormField } from "@/shared/types";

export const defaultValues: TSignUpVisitorDto = {
    email: "",
    password: "",
    fio: "",
    age: 18
};

export const formFields: TFormField<TSignUpVisitorDto>[] = [
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
        name: "age",
        label: "Возраст",
        type: "number",
        placeholder: "Введите возраст"
    }
];
