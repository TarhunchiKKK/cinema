import { Theme } from "../../types";

export type TThemeProviderProps = {
    children: React.ReactNode;
};

export type TThemeProviderState = {
    theme: Theme;
    setTheme: (_: Theme) => void;
};
