import { localStorageService } from "@/shared/utils";
import { Theme } from "../../types";
import { TThemeProviderState } from "./types";
import { createContext } from "react";

export const initialState: TThemeProviderState = {
    theme: (localStorageService.theme.get() as Theme) ?? Theme.DARK,
    setTheme: () => null
};

export const ThemeProviderContext = createContext<TThemeProviderState>(initialState);
