import { Card, CardContent, CardFooter } from "@/shared/ui";
import { TFilmProps } from "./types";
import { FilmPlaceholder } from "@/shared/assets";

export function Film({ film }: TFilmProps) {
    return (
        <Card>
            <CardContent className="rounded-sm mb-4">
                <img src={FilmPlaceholder} alt={film.title} />
            </CardContent>

            <CardFooter className="block">
                <h4 className="font-bold text-base leading-6 text-white">{film.title}</h4>

                <p className="font-medium text-base leading-6 text-[#AFB2B6]">{film.year}</p>

                <p className="font-medium text-base leading-6 text-[#AFB2B6] capitalize">{film.country}</p>
            </CardFooter>
        </Card>
    );
}
