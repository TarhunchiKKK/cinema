import { useParams } from "react-router-dom";
import { useVisitorSeanses } from "./hooks";
import { TId } from "@/shared/types";
import { GridContainer } from "@/shared/ui";
import { Seans } from "@/entities/seanses";

export function VisitorSeansesPage() {
    const { visitorId } = useParams();

    const { seanses } = useVisitorSeanses(visitorId as TId);

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
