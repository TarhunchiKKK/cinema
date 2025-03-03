import { TUpdateHallDto, updateHall } from "@/entities/halls";
import { QUERY_KEYS } from "@/shared/constants";
import { TId, TValidationErrors } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useQueryClient, useMutation } from "@tanstack/react-query";
import { AxiosError } from "axios";

export function useUpdateHall(hallId: TId) {
    const token = localStorageService.token.get();

    const queryClient = useQueryClient();

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.FILMS,
        mutationFn: (dto: TUpdateHallDto) => updateHall(hallId, dto, token),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: QUERY_KEYS.FILMS });
        }
    });

    return {
        updateHall: mutate,
        isPending,
        error: error as AxiosError<TValidationErrors<TUpdateHallDto>>
    };
}
