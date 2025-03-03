import { TFilm } from "@/entities/films";
import { TId } from "@/shared/types";

export type TSeans = {
    id: TId;

    date: Date;

    price: number;

    duration: number;

    film: TFilm;
};
