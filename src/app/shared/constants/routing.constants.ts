import { TId } from '../types';

export const ROUTES = {
    INDEX: '',
    HOME: 'home',
    FILMS: {
        AFISHA: '/',
        ONE_FILM: {
            PATTERN: 'films/:filmId',
            CREATE: (filmId: TId) => `films/${filmId}`,
        },
    },
    AUTH: {
        INDEX: 'auth',
        SIGN_UP: 'auth/sign-up',
        SIGN_IN: 'auth/sign-in',
    },
    VISITOR: {
        INDEX: {
            PATTERN: 'visitor/:visitorId',
            CREATE: (visitorId: TId) => `visitor/${visitorId}`,
        },
        FILMS: {
            PATTERN: 'visitor/:visitorId/films',
            CREATE: (visitorId: TId) => `visitor/${visitorId}/films`,
        },
        SEANSES: {
            PATTERN: 'visitor/:visitorId/seanses',
            CREATE: (visitorId: TId) => `visitor/${visitorId}/seanses`,
        },
    },
    EMPLOYEE: {
        INDEX: {
            PATTERN: 'employee/:employeeId',
            CREATE: (employeeId: TId) => `employee/${employeeId}`,
        },
        FILMS: {
            PATTERN: 'employee/:employeeId/films',
            CREATE: (employeeId: TId) => `employee/${employeeId}/films`,
        },
        SEANSES: {
            PATTERN: 'employee/:employeeId/seanses',
            CREATE: (employeeId: TId) => `employee/${employeeId}/seanses`,
        },
        HALLS: {
            PATTERN: 'employee/:employeeId/halls',
            CREATE: (employeeId: TId) => `employee/${employeeId}/halls`,
        },
    },
};
