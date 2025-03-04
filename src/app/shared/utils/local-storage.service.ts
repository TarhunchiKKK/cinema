import { environment } from '../../../environments/environment.development';

export const localStorageService = {
    token: {
        key: environment.localStorageTokenKey,
        get: () => {
            return localStorage.getItem(localStorageService.token.key);
        },
        set: (token: string) => {
            localStorage.setItem(localStorageService.token.key, token);
        },
        remove: () => {
            localStorage.removeItem(localStorageService.token.key);
        },
    },
    theme: {
        key: environment.localStorageThemeKey,
        get: () => {
            return localStorage.getItem(localStorageService.theme.key);
        },
        set: (theme: string) => {
            localStorage.setItem(localStorageService.theme.key, theme);
        },
        remove: () => {
            localStorage.removeItem(localStorageService.theme.key);
        },
    },
};
