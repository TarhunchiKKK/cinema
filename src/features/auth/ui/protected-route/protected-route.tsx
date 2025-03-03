import { PropsWithChildren } from "react";
import { TProtectedRouteProps } from "./types";
import { localStorageService } from "@/shared/utils";
import { Navigate } from "react-router-dom";
import { useProfileStore } from "@/entities/profiles";

export function ProtectedRoute({ redirectRoute, children }: PropsWithChildren<TProtectedRouteProps>) {
    const token = localStorageService.token.get();

    const profile = useProfileStore(state => state.profile);

    if (!token || !profile) {
        return <Navigate to={redirectRoute} />;
    }

    return <>{children}</>;
}
