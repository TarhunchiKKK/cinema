import { TId } from "../types";
import { ENV } from "./env";

export const QUERY_URLS = {
    AUTH: {
        SIGN_UP_VISITOR: `${ENV.API_URL}/auth/sign-up/visitor`,
        SIGN_UP_EMPLOYEE: `${ENV.API_URL}/auth/sign-up/employee`,
        SIGN_IN: `${ENV.API_URL}/auth/sign-in`,
        ME: `${ENV.API_URL}/auth/profile`
    },
    FILMS: {
        CREATE: `${ENV.API_URL}/films`,
        FIND_ALL: `${ENV.API_URL}/films`,
        UPDATE: (filmId: TId) => `${ENV.API_URL}/films/${filmId}`,
        DELETE: (filmId: TId) => `${ENV.API_URL}/films/${filmId}`
    },
    SEANSES: {
        CREATE: `${ENV.API_URL}/seanses`,
        UPDATE: (seanceId: TId) => `${ENV.API_URL}/seanses/${seanceId}`,
        FIND_ALL_BY_FILM_ID: (seanseId: TId) => `${ENV.API_URL}/seanses/${seanseId}`,
        FIND_ALL_BY_VISITOR_ID: (visitorId: TId) => `${ENV.API_URL}/seanses/visitor/${visitorId}`,
        FIND_ALL_BY_EMPLOYEE_ID: (employeeId: TId) => `${ENV.API_URL}/seanses/employee/${employeeId}`
    },
    HALLS: {
        CREATE: `${ENV.API_URL}/halls`,
        FIND_ALL: `${ENV.API_URL}/halls`,
        UPDATE: (hallId: TId) => `${ENV.API_URL}/halls/${hallId}`,
        DELETE: (hallId: TId) => `${ENV.API_URL}/halls/${hallId}`
    },
    VISITORS: {
        TOGGLE_SEANS: `${ENV.API_URL}/visitors/toggle-seans`
    },
    EMPLOYEES: {
        TOGGLE_SEANS: `${ENV.API_URL}/employees/toggle-seans`
    }
};

export const QUERY_KEYS = {
    FILMS: ["films"]
};
