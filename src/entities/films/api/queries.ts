import { TCreateFilmDto, TSearchFilmsQueryArgs, TUpdateFilmDto } from "./types";
import axios from "axios";
import { TFilm } from "../types";
import { QUERY_URLS } from "@/shared/constants";
import { QueryHeadersBuilder } from "@/shared/utils";
import { TId } from "@/shared/types";

export async function createFilm(dto: TCreateFilmDto, token: string) {
    const response = await axios.post<TFilm>(QUERY_URLS.FILMS.CREATE, dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function findAllFilms(args: TSearchFilmsQueryArgs) {
    const response = await axios.get<TFilm[]>(QUERY_URLS.FILMS.FIND_ALL, {
        headers: new QueryHeadersBuilder().get(),
        params: args,
        data: args
    });

    return response.data;
}

export async function updateFilm(filmId: TId, dto: TUpdateFilmDto, token: string) {
    await axios.patch<void>(QUERY_URLS.FILMS.UPDATE(filmId), dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}

export async function deleteFilm(filmId: string, token: string) {
    await axios.delete<void>(QUERY_URLS.FILMS.DELETE(filmId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}
