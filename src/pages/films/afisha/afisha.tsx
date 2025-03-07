import { useState } from "react";
import { GridContainer } from "@/shared/ui";
import { CountriesDropdown, Film } from "@/entities/films";
import { ProtectedItem } from "@/features/roles";
import { Role } from "@/entities/profiles";
import { CreateFilmModal } from "@/widgets/film-modals";
import { useFilms } from "./hooks";

export function AfishaPage() {
    const [country, setCountry] = useState<string | undefined>();

    const { films } = useFilms({ country });

    return (
        <>
            <div className="flex flex-row justify-between items-center mb-4">
                <ProtectedItem requiredRoles={[Role.ROLE_EMPLOYEE]}>
                    <CreateFilmModal />
                </ProtectedItem>

                <CountriesDropdown value={country} onChange={setCountry} />
            </div>

            <GridContainer>
                {films?.map(film => (
                    <Film key={film.id} film={film} />
                ))}
            </GridContainer>

            {films && films.length === 0 && (
                <p className="w-full text-center font-bold text-lg leading-7 text-white">Фильмы не найдены</p>
            )}
        </>
    );
}
