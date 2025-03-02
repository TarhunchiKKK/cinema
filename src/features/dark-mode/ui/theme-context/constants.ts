import { localStorageService } from "@/shared/utils";
import { Theme } from "../../types";
import { TThemeProviderState } from "./types";

export const initialState: TThemeProviderState = {
    theme: (localStorageService.theme.get() as Theme) ?? Theme.LIGHT,
    setTheme: () => null
};
