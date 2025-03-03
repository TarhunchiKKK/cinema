import { findAllHalls, TSearchHallsQueryArgs } from "@/entities/halls";
import { QUERY_KEYS } from "@/shared/constants";
import { localStorageService } from "@/shared/utils";
import { useQuery } from "@tanstack/react-query";

export function useHalls(queryArgs: TSearchHallsQueryArgs) {
    const token = localStorageService.token.get();

    const { data, isPending } = useQuery({
        queryKey: [...QUERY_KEYS.HALLS, queryArgs.type],
        queryFn: () => findAllHalls(queryArgs, token)
    });

    return { halls: data, isPending };
}
