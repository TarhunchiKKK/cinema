import { ROUTES } from "@/shared/constants";
import { TId } from "@/shared/types";

export function getNavigationLinks(id: TId) {
    return [
        {
            label: "Афиша",
            href: ROUTES.EMPLOYEE.FILMS.CREATE(id)
        },
        {
            label: "Мои сеансы",
            href: ROUTES.EMPLOYEE.SEANSES.CREATE(id)
        },
        {
            label: "Залы",
            href: ROUTES.EMPLOYEE.HALLS.CREATE(id)
        }
    ];
}
