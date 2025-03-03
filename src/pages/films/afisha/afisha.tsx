import { useState } from "react";
import { useFilms } from "./hooks";
import { GridContainer } from "@/shared/ui";
import { CountriesDropdown, Film } from "@/entities/films";

export function AfishaPage() {
    const [country, setCountry] = useState<string | undefined>();

    const { films } = useFilms({ country });

    return (
        <>
            <div className="flex flex-row justify-end items-center mb-4">
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
