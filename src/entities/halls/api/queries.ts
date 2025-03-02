import axios from "axios";
import { TCreateHallDto, TSearchHallsQueryArgs, TUpdateHallDto } from "./types";
import { THall } from "../types";
import { QUERY_URLS } from "@/shared/constants";
import { QueryHeadersBuilder } from "@/shared/utils";
import { TId } from "@/shared/types";

export async function createHall(dto: TCreateHallDto, token: string | null) {
    const response = await axios.post<THall>(QUERY_URLS.HALLS.CREATE, dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function findAllHalls(args: TSearchHallsQueryArgs, token: string | null) {
    const response = await axios.get<THall[]>(QUERY_URLS.HALLS.FIND_ALL, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get(),
        params: args,
        data: args
    });
    return response.data;
}

export async function updateHall(hallId: TId, dto: TUpdateHallDto, token: string | null) {
    await axios.patch<void>(QUERY_URLS.HALLS.UPDATE(hallId), dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}

export async function deleteHall(hallId: TId, token: string | null) {
    await axios.delete<void>(QUERY_URLS.HALLS.DELETE(hallId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}
