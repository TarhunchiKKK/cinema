export type TCreateHallDto = {
    type: string;

    seatsCount: number;
};

export type TUpdateHallDto = {
    type: string;

    seatsCount: number;
};

export type TSearchHallsQueryArgs = {
    type?: string;
};
