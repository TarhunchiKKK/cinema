import { ENV } from "../constants";

export const localStorageService = {
    token: {
        key: ENV.LOCAL_STORAGE_TOKEN_KEY,
        get: () => {
            return localStorage.getItem(localStorageService.token.key);
        },
        set: (token: string) => {
            localStorage.setItem(localStorageService.token.key, token);
        },
        remove: () => {
            localStorage.removeItem(localStorageService.token.key);
        }
    },
    theme: {
        key: ENV.LOCAL_STORAGE_THEME_KEY,
        get: () => {
            return localStorage.getItem(localStorageService.theme.key);
        },
        set: (theme: string) => {
            localStorage.setItem(localStorageService.theme.key, theme);
        },
        remove: () => {
            localStorage.removeItem(localStorageService.theme.key);
        }
    }
};
