import { Role } from "@/entities/profiles";
import { PropsWithChildren } from "react";

export type TProtectedRouteProps = PropsWithChildren<{
    requiredRoles: Role[];

    redirectRoute: string;
}>;
