import { useParams } from "react-router-dom";
import { useEmployeeSeanses } from "./hooks";
import { TId } from "@/shared/types";
import { Seans } from "@/entities/seanses";
import { GridContainer } from "@/shared/ui";

export function EmployeeSeansesPage() {
    const { employeeId } = useParams();

    const { seanses } = useEmployeeSeanses(employeeId as TId);

    return (
        <>
            <GridContainer>
                {seanses?.map(seans => (
                    <Seans key={seans.id} seans={seans} />
                ))}
            </GridContainer>

            {seanses && seanses.length === 0 && (
                <p className="w-full text-center font-bold text-lg leading-7 text-white">Сеансы не найдены</p>
            )}
        </>
    );
}
