import { Role } from "@/entities/profiles";
import { PropsWithChildren } from "react";

export type TProtectedItemProps = PropsWithChildren<{
    requiredRoles: Role[];
}>;
