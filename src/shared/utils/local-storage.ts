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
    }
};
