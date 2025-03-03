import axios from "axios";
import { TCreateSeansDto, TUpdateSeansDto } from "./types";
import { TSeans } from "../types";
import { QUERY_URLS } from "@/shared/constants";
import { QueryHeadersBuilder } from "@/shared/utils";
import { TId } from "@/shared/types";

export async function createSeans(dto: TCreateSeansDto, token: string | null) {
    const response = await axios.post<TSeans>(QUERY_URLS.SEANSES.CREATE, dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function updateSeans(seansId: TId, dto: TUpdateSeansDto, token: string | null) {
    await axios.patch<void>(QUERY_URLS.SEANSES.UPDATE(seansId), dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}

export async function findSeansesByFilm(filmId: TId) {
    const response = await axios.get<TSeans[]>(QUERY_URLS.SEANSES.FIND_ALL_BY_FILM_ID(filmId));
    return response.data;
}

export async function findSeansesByVisitor(visitorId: TId, token: string | null) {
    const response = await axios.get<TSeans[]>(QUERY_URLS.SEANSES.FIND_ALL_BY_VISITOR_ID(visitorId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function findSeansesByEmployee(employeeId: TId, token: string | null) {
    const response = await axios.get<TSeans[]>(QUERY_URLS.SEANSES.FIND_ALL_BY_EMPLOYEE_ID(employeeId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}
