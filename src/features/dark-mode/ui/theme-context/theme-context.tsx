import { createContext } from "react";
import { TThemeProviderProps, TThemeProviderState } from "./types";
import { initialState } from "./constants";
import { Theme } from "../../types";

export const ThemeProviderContext = createContext<TThemeProviderState>(initialState);

export function ThemeProvider({ children }: TThemeProviderProps) {
    const setTheme = (theme: Theme) => {
        window.document.documentElement.classList.remove("light", "dark");
        window.document.documentElement.classList.add(theme);
    };

    const value = {
        theme: initialState.theme,
        setTheme
    };

    return <ThemeProviderContext.Provider value={value}>{children}</ThemeProviderContext.Provider>;
}
