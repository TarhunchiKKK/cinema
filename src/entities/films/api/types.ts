export type TCreateFilmDto = {
    title: string;

    year: number;

    country: string;
};

export type TUpdateFilmDto = {
    title: string;

    year: number;

    country: string;
};

export type TSearchFilmsQueryArgs = {
    country?: string;
};
