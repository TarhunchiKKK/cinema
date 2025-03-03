import { TId } from "@/shared/types";
import axios from "axios";
import { TVisitor } from "../types";
import { QUERY_URLS } from "@/shared/constants";
import { QueryHeadersBuilder } from "@/shared/utils";
import { TToggleVisitorSeansDto } from "./types";

export async function findVisitorById(visitorId: TId, token: string | null) {
    const response = await axios.get<TVisitor>(QUERY_URLS.VISITORS.FIND_ONE_BY_ID(visitorId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function toggleVisitorSeans(dto: TToggleVisitorSeansDto, token: string | null) {
    await axios.patch<void>(QUERY_URLS.VISITORS.TOGGLE_SEANS, dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}
