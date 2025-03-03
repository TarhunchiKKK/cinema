import { createHall, TCreateHallDto } from "@/entities/halls";
import { QUERY_KEYS } from "@/shared/constants";
import { TValidationErrors } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { AxiosError } from "axios";

export function useCreateHall() {
    const token = localStorageService.token.get();

    const queryClient = useQueryClient();

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.HALLS,
        mutationFn: (dto: TCreateHallDto) => createHall(dto, token),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: QUERY_KEYS.HALLS });
        }
    });

    return {
        createHall: mutate,
        isPending,
        error: error as AxiosError<TValidationErrors<TCreateHallDto>>
    };
}
