import { useState } from "react";
import { useHalls } from "./hooks";
import { Hall, HallTypesDropdown } from "@/entities/halls/ui";
import { GridContainer } from "@/shared/ui";
import { CreateHallModal } from "@/widgets/hall-modals";
import { ProtectedItem } from "@/features/roles";
import { Role } from "@/entities/profiles";

export function HallsPage() {
    const [type, setType] = useState<string | undefined>();

    const { halls } = useHalls({ type });

    return (
        <>
            <div className="flex flex-row-reverse justify-between items-center mb-4">
                <HallTypesDropdown value={type} onChange={setType} />

                <ProtectedItem requiredRoles={[Role.ROLE_EMPLOYEE]}>
                    <CreateHallModal />
                </ProtectedItem>
            </div>

            <GridContainer>
                {halls?.map(hall => (
                    <Hall key={hall.id} hall={hall} />
                ))}
            </GridContainer>

            {halls && halls.length === 0 && (
                <p className="w-full text-center font-bold text-lg leading-7 text-white">Залы не найдены</p>
            )}
        </>
    );
}
