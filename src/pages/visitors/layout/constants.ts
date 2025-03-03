import { ROUTES } from "@/shared/constants";
import { TId } from "@/shared/types";

export function getNavigationLinks(id: TId) {
    return [
        {
            label: "Афиша",
            href: ROUTES.VISITOR.FILMS.CREATE(id)
        },
        {
            label: "Мои сеансы",
            href: ROUTES.VISITOR.SEANSES.CREATE(id)
        }
    ];
}
