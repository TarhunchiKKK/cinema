import { toggleEmployeeSeans } from "@/entities/employees";
import { Role, useProfileStore } from "@/entities/profiles";
import { TSeans } from "@/entities/seanses";
import { toggleVisitorSeans } from "@/entities/visitors";
import { QUERY_KEYS } from "@/shared/constants";
import { localStorageService } from "@/shared/utils";
import { useMutation } from "@tanstack/react-query";

export function useToggleSeans() {
    const token = localStorageService.token.get();

    const role = useProfileStore(state => state.profile!.profile.role);
    const toggleSeans = useProfileStore(state => state.toggleSeans);

    const { mutate, isPending } = useMutation({
        mutationKey: [...QUERY_KEYS.SEANSES, token, role],
        mutationFn: (dto: TSeans) => {
            const fn = role === Role.ROLE_EMPLOYEE ? toggleEmployeeSeans : toggleVisitorSeans;
            return fn({ seansId: dto.id }, token);
        },
        onSuccess: (_, seans) => {
            toggleSeans(seans);
        }
    });

    return { toggleSeans: mutate, isPending };
}
