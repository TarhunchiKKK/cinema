import { useProfileStore } from "@/entities/profiles";
import { TProtectedItemProps } from "./types";

export function ProtectedItem({ requiredRoles, children }: TProtectedItemProps) {
    const role = useProfileStore(state => state.profile?.profile.role);

    if (role && requiredRoles.includes(role)) {
        return <>{children}</>;
    }

    return <></>;
}
