import { findFilmById } from "@/entities/films";
import { QUERY_KEYS } from "@/shared/constants";
import { TId } from "@/shared/types";
import { useQuery } from "@tanstack/react-query";

export function useFilm(filmId: TId) {
    const { data } = useQuery({
        queryKey: [...QUERY_KEYS.FILMS, filmId],
        queryFn: async () => findFilmById(filmId)
    });

    return { film: data };
}
