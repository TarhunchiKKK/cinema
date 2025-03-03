import { TUpdateFilmDto, updateFilm } from "@/entities/films";
import { QUERY_KEYS } from "@/shared/constants";
import { TId, TValidationErrors } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { AxiosError } from "axios";

export function useUpdateFilm(filmId: TId) {
    const token = localStorageService.token.get();

    const queryClient = useQueryClient();

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.FILMS,
        mutationFn: (dto: TUpdateFilmDto) => updateFilm(filmId, dto, token),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: QUERY_KEYS.FILMS });
        }
    });

    return {
        updateFilm: mutate,
        isPending,
        error: error as AxiosError<TValidationErrors<TUpdateFilmDto>>
    };
}
