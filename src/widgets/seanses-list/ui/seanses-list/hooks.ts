import { findSeansesByFilm } from "@/entities/seanses";
import { QUERY_KEYS } from "@/shared/constants";
import { TId } from "@/shared/types";
import { useQuery } from "@tanstack/react-query";

export function useFilmSeanses(filmId: TId) {
    const { data, isPending } = useQuery({
        queryKey: [...QUERY_KEYS.SEANSES, filmId],
        queryFn: () => findSeansesByFilm(filmId)
    });

    return { seanses: data, isPending };
}
