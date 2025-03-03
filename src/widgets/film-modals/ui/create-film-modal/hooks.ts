import { createFilm, TCreateFilmDto } from "@/entities/films";
import { QUERY_KEYS } from "@/shared/constants";
import { TValidationErrors } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { AxiosError } from "axios";

export function useCreateFilm() {
    const token = localStorageService.token.get();

    const queryClient = useQueryClient();

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.FILMS,
        mutationFn: (dto: TCreateFilmDto) => createFilm(dto, token),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: QUERY_KEYS.FILMS });
        }
    });

    return {
        createFilm: mutate,
        isPending,
        error: error as AxiosError<TValidationErrors<TCreateFilmDto>>
    };
}
