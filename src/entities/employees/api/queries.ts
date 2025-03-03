import { TId } from "@/shared/types";
import axios from "axios";
import { TEmployee } from "../types";
import { QUERY_URLS } from "@/shared/constants";
import { QueryHeadersBuilder } from "@/shared/utils";
import { TToggleEmployeeSeansDto } from "./types";

export async function findEmployeeById(employeeId: TId, token: string | null) {
    const response = await axios.get<TEmployee>(QUERY_URLS.EMPLOYEES.FIND_ONE_BY_ID(employeeId), {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}

export async function toggleEmployeeSeans(dto: TToggleEmployeeSeansDto, token: string | null) {
    await axios.patch<void>(QUERY_URLS.EMPLOYEES.TOGGLE_SEANS, dto, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
}
