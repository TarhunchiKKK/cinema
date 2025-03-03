import { useState } from "react";
import { useHalls } from "./hooks";
import { Hall, HallTypesDropdown } from "@/entities/halls/ui";
import { GridContainer } from "@/shared/ui";

export function HallsPage() {
    const [type, setType] = useState<string | undefined>();

    const { halls } = useHalls({ type });

    return (
        <>
            <div className="flex flex-row justify-end items-center mb-4">
                <HallTypesDropdown value={type} onChange={setType} />
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
