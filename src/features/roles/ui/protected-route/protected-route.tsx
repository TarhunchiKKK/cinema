import { useProfileStore } from "@/entities/profiles";
import { TProtectedRouteProps } from "./types";
import { Navigate } from "react-router-dom";

export function ProtectedRoute({ requiredRoles, redirectRoute, children }: TProtectedRouteProps) {
    const role = useProfileStore(state => state.profile?.profile.role);

    if (role && requiredRoles.includes(role)) {
        return <>{children}</>;
    }

    return <Navigate to={redirectRoute} />;
}
