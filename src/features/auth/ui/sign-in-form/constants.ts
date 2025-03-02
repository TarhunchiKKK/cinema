import { TSignInDto } from "@/entities/profiles";
import { TFormField } from "../../../../shared/types";

export const defaultvalues: TSignInDto = {
    email: "",
    password: ""
};

export const formFields: TFormField<TSignInDto>[] = [
    {
        name: "email",
        label: "Username",
        placeholder: "Enter username",
        type: "text"
    },
    {
        name: "password",
        label: "Password",
        placeholder: "Enter password",
        type: "password"
    }
];
