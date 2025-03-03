import { TId } from "@/shared/types";

export type TCreateSeansDto = {
    date: Date;

    price: number;

    duration: number;

    filmId: TId;

    hallId: TId;
};

export type TUpdateSeansDto = {
    date: Date;

    price: number;

    duration: number;
};
