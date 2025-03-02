import { Moon, Sun } from "lucide-react";
import { Theme } from "../../types";
import { Button } from "@/shared/ui";
import { DropdownMenu, DropdownMenuTrigger, DropdownMenuContent, DropdownMenuItem } from "@/shared/ui";
import { useContext } from "react";
import { ThemeProviderContext } from "../theme-context";

export function ThemeSwitch() {
    const { setTheme } = useContext(ThemeProviderContext);

    return (
        <DropdownMenu>
            <DropdownMenuTrigger asChild>
                <Button variant="outline" size="icon">
                    <Sun className="h-[1.2rem] w-[1.2rem] rotate-0 scale-100 transition-all dark:-rotate-90 dark:scale-0" />
                    <Moon className="absolute h-[1.2rem] w-[1.2rem] rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100" />
                    <span className="sr-only">Смена темы</span>
                </Button>
            </DropdownMenuTrigger>

            <DropdownMenuContent align="end">
                <DropdownMenuItem onClick={() => setTheme(Theme.LIGHT)}>Светлая</DropdownMenuItem>
                <DropdownMenuItem onClick={() => setTheme(Theme.DARK)}>Тёмная</DropdownMenuItem>
            </DropdownMenuContent>
        </DropdownMenu>
    );
}
