import { THall } from "@/entities/halls";

export function omitId(film: THall): Omit<THall, "id"> {
    return {
        type: film.type,
        seatsCount: film.seatsCount
    };
}
