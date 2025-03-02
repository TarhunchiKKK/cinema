import { TThemeProviderProps } from "./types";
import { initialState, ThemeProviderContext } from "./constants";
import { Theme } from "../../types";
import { useEffect } from "react";

export function ThemeProvider({ children }: TThemeProviderProps) {
    const setTheme = (theme: Theme) => {
        window.document.documentElement.classList.remove("light", "dark");
        window.document.documentElement.classList.add(theme);
    };

    useEffect(() => {
        setTheme(initialState.theme);
    }, []);

    return (
        <ThemeProviderContext.Provider value={{ theme: initialState.theme, setTheme }}>
            {children}
        </ThemeProviderContext.Provider>
    );
}
