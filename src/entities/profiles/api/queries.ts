import axios from "axios";
import { TSignInDto, TSignInResponse, TSignUpEmployeeDto, TSignUpResponse, TSignUpVisitorDto } from "./dtos";
import { QUERY_URLS } from "@/shared/constants";
import { TProfile } from "../types";
import { QueryHeadersBuilder } from "@/shared/utils";

export async function signUpVisitor(dto: TSignUpVisitorDto) {
    const response = await axios.post<TSignUpResponse>(QUERY_URLS.AUTH.SIGN_UP_VISITOR, dto);
    return response.data;
}

export async function signUpEmployee(dto: TSignUpEmployeeDto) {
    const response = await axios.post<TSignUpResponse>(QUERY_URLS.AUTH.SIGN_UP_EMPLOYEE, dto);
    return response.data;
}

export async function signIn(dto: TSignInDto) {
    const response = await axios.post<TSignInResponse>(QUERY_URLS.AUTH.SIGN_IN, dto);
    return response.data;
}

export async function getProfile(token: string) {
    const response = await axios.get<TProfile>(QUERY_URLS.AUTH.ME, {
        headers: new QueryHeadersBuilder().setBearerToken(token).get()
    });
    return response.data;
}
