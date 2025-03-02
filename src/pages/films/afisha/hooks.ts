import { findAllFilms, TSearchFilmsQueryArgs } from "@/entities/films";
import { QUERY_KEYS } from "@/shared/constants/query";
import { useQuery } from "@tanstack/react-query";

export function useFilms(queryArgs: TSearchFilmsQueryArgs) {
    const { data, isPending } = useQuery({
        queryKey: [...QUERY_KEYS.FILMS, queryArgs.country],
        queryFn: () => findAllFilms(queryArgs)
    });

    return { films: data, isPending };
}
