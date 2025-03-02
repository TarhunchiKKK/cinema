import { ThemeSwitch } from "@/features/dark-mode";
import { AuthButton } from "../auth-button";

export function Header() {
    return (
        <header className="py-4 border-b border-t shadow-sm rounded-b-xl">
            <div className="container mx-auto">
                <div className="flex flex-row justify-between items-center w-full">
                    <ThemeSwitch />

                    <AuthButton />
                </div>
            </div>
        </header>
    );
}
