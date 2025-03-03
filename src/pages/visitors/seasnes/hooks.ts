import { findSeansesByVisitor } from "@/entities/seanses";
import { QUERY_KEYS } from "@/shared/constants";
import { TId } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useQuery } from "@tanstack/react-query";

export function useVisitorSeanses(visitorId: TId) {
    const token = localStorageService.token.get();

    const { data, isPending } = useQuery({
        queryKey: [...QUERY_KEYS.SEANSES.VISITOR, token],
        queryFn: () => findSeansesByVisitor(visitorId, token)
    });

    return { seanses: data, isPending };
}
