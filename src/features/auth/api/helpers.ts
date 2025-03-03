import { Role, TSignInResponse } from "@/entities/profiles";
import { ROUTES } from "@/shared/constants";

export function getSignInRedirectRoute(response: TSignInResponse) {
    switch (response.profile.role) {
        case Role.ROLE_EMPLOYEE:
            return ROUTES.EMPLOYEE.INDEX.CREATE(response.profile.id);
        case Role.ROLE_VISITOR:
            return ROUTES.VISITOR.INDEX.CREATE(response.profile.id);
    }
}
