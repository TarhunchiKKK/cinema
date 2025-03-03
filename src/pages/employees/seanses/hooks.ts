import { findSeansesByEmployee } from "@/entities/seanses";
import { QUERY_KEYS } from "@/shared/constants";
import { TId } from "@/shared/types";
import { localStorageService } from "@/shared/utils";
import { useQuery } from "@tanstack/react-query";

export function useEmployeeSeanses(employeeId: TId) {
    const token = localStorageService.token.get();

    const { data, isPending } = useQuery({
        queryKey: [...QUERY_KEYS.SEANSES.EMPLOYEE, token],
        queryFn: () => findSeansesByEmployee(employeeId, token)
    });

    return { seanses: data, isPending };
}
