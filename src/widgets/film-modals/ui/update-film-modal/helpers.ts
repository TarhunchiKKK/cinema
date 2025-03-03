import { TFilm } from "@/entities/films";

export function omitId(film: TFilm): Omit<TFilm, "id"> {
    return {
        title: film.title,
        year: film.year,
        country: film.country
    };
}
