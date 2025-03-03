import { useState } from "react";
import { useFilms } from "./hooks";
import { GridContainer, NavigationMenu, NavigationMenuItem, NavigationMenuLink, NavigationMenuList } from "@/shared/ui";
import { CountriesDropdown, Film } from "@/entities/films";
import { ROUTES } from "@/shared/constants";
import { NavLink } from "react-router-dom";

export function AfishaPage() {
    const [country, setCountry] = useState<string | undefined>();

    const { films } = useFilms({ country });

    return (
        <>
            <div className="mb-4">
                <NavigationMenu>
                    <NavigationMenuList>
                        <NavigationMenuItem>
                            <NavLink
                                to={ROUTES.EMPLOYEE.FILMS.CREATE("")}
                                className={({ isActive }) => (isActive ? "bg-white text-black" : "")}
                            >
                                <NavigationMenuLink>Фильмы</NavigationMenuLink>
                            </NavLink>
                        </NavigationMenuItem>
                        <NavigationMenuItem>
                            <NavLink
                                to={ROUTES.AFISHA}
                                className={({ isActive }) => (isActive ? "bg-accent text-accent-foreground" : "")}
                            >
                                <NavigationMenuLink>Мои сеансы</NavigationMenuLink>
                            </NavLink>
                        </NavigationMenuItem>
                        <NavigationMenuItem>
                            <NavLink
                                to={ROUTES.EMPLOYEE.HALLS.CREATE("")}
                                className={({ isActive }) => (isActive ? "bg-white text-black" : "")}
                            >
                                <NavigationMenuLink>Залы</NavigationMenuLink>
                            </NavLink>
                        </NavigationMenuItem>
                    </NavigationMenuList>
                </NavigationMenu>
            </div>

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
