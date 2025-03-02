import { PropsWithChildren } from "react";
import { TProtectedRouteProps } from "./types";
import { localStorageService } from "@/shared/utils";
import { Navigate } from "react-router-dom";

export function ProtectedRoute({ redirectRoute, children }: PropsWithChildren<TProtectedRouteProps>) {
    const token = localStorageService.token.get();

    if (!token) {
        return <Navigate to={redirectRoute} />;
    }

    return <>{children}</>;
}
