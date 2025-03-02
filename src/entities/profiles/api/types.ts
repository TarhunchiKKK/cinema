import { TProfile } from "../types";

export type TSignUpEmployeeDto = {
    email: string;

    password: string;

    fio: string;

    post: string;

    experience: number;
};

export type TSignUpVisitorDto = {
    email: string;

    password: string;

    fio: string;

    age: number;
};

export type TSignUpResponse = {
    profile: TProfile;

    token: string;
};

export type TSignInDto = {
    email: string;

    password: string;
};

export type TSignInResponse = {
    profile: TProfile;

    token: string;
};
