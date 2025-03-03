import { findEmployeeById } from "@/entities/employees";
import { Role, TProfile, TSignInResponse } from "@/entities/profiles";
import { findVisitorById } from "@/entities/visitors";
import { ROUTES } from "@/shared/constants";

export function getSignInRedirectRoute(response: TSignInResponse) {
    switch (response.profile.role) {
        case Role.ROLE_EMPLOYEE:
            return ROUTES.EMPLOYEE.INDEX.CREATE(response.profile.id);
        case Role.ROLE_VISITOR:
            return ROUTES.VISITOR.INDEX.CREATE(response.profile.id);
    }
}

export async function getProfileData(response: { profile: TProfile; token: string }) {
    switch (response.profile.role) {
        case Role.ROLE_EMPLOYEE:
            return await findEmployeeById(response.profile.id, response.token);
        case Role.ROLE_VISITOR:
            return await findVisitorById(response.profile.id, response.token);
    }
}
