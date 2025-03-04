import { environment } from '../../../environments/environment';
import { TId } from '../types';

export const QUERY_URLS = {
    AUTH: {
        SIGN_UP_VISITOR: `${environment.apiUrl}/auth/sign-up/visitor`,
        SIGN_UP_EMPLOYEE: `${environment.apiUrl}/auth/sign-up/employee`,
        SIGN_IN: `${environment.apiUrl}/auth/sign-in`,
        ME: `${environment.apiUrl}/auth/profile`,
    },
    FILMS: {
        CREATE: `${environment.apiUrl}/films`,
        FIND_ONE_BY_ID: (filmId: TId) => `${environment.apiUrl}/films/${filmId}`,
        FIND_ALL: `${environment.apiUrl}/films`,
        UPDATE: (filmId: TId) => `${environment.apiUrl}/films/${filmId}`,
        DELETE: (filmId: TId) => `${environment.apiUrl}/films/${filmId}`,
    },
    SEANSES: {
        CREATE: `${environment.apiUrl}/seanses`,
        UPDATE: (seanceId: TId) => `${environment.apiUrl}/seanses/${seanceId}`,
        FIND_ALL_BY_FILM_ID: (seanseId: TId) => `${environment.apiUrl}/seanses/${seanseId}`,
        FIND_ALL_BY_VISITOR_ID: (visitorId: TId) => `${environment.apiUrl}/seanses/visitor/${visitorId}`,
        FIND_ALL_BY_EMPLOYEE_ID: (employeeId: TId) => `${environment.apiUrl}/seanses/employee/${employeeId}`,
    },
    HALLS: {
        CREATE: `${environment.apiUrl}/halls`,
        FIND_ALL: `${environment.apiUrl}/halls`,
        UPDATE: (hallId: TId) => `${environment.apiUrl}/halls/${hallId}`,
        DELETE: (hallId: TId) => `${environment.apiUrl}/halls/${hallId}`,
    },
    VISITORS: {
        FIND_ONE_BY_ID: (visitorId: TId) => `${environment.apiUrl}/visitors/${visitorId}`,
        TOGGLE_SEANS: `${environment.apiUrl}/visitors/toggle-seans`,
    },
    EMPLOYEES: {
        FIND_ONE_BY_ID: (employeeId: TId) => `${environment.apiUrl}/employees/${employeeId}`,
        TOGGLE_SEANS: `${environment.apiUrl}/employees/toggle-seans`,
    },
};

export const QUERY_KEYS = {
    AUTH: ['auth'],
    FILMS: ['films'],
    HALLS: ['halls'],
    SEANSES: ['film-seanses'],
};
