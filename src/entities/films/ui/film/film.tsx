import { Card, CardContent, CardFooter } from "@/shared/ui";
import { TFilmProps } from "./types";
import { FilmPlaceholder } from "@/shared/assets";
import { NavLink } from "react-router-dom";
import { ROUTES } from "@/shared/constants";

export function Film({ film, disableLink }: TFilmProps) {
    return (
        <Card>
            <CardContent className="rounded-sm mb-4">
                {disableLink ? (
                    <img src={FilmPlaceholder} alt={film.title} />
                ) : (
                    <NavLink to={ROUTES.FILMS.ONE_FILM.CREATE(film.id)}>
                        <img src={FilmPlaceholder} alt={film.title} />
                    </NavLink>
                )}
            </CardContent>

            <CardFooter className="block">
                <h4 className="font-bold text-base leading-6 text-white">{film.title}</h4>

                <p className="font-medium text-base leading-6 text-[#AFB2B6]">{film.year}</p>

                <p className="font-medium text-base leading-6 text-[#AFB2B6] capitalize">{film.country}</p>
            </CardFooter>
        </Card>
    );
}
