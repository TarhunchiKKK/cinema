import { Role } from "./role";

export type TProfile = {
    id: string;

    email: string;

    password: string;

    role: Role;
};
