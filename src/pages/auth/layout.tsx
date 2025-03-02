import { ThemeSwitch } from "@/features/dark-mode";
import { Outlet } from "react-router-dom";

export function AuthLayout() {
    return (
        <main>
            <div>
                <ThemeSwitch />
            </div>

            <div className="fixed top-1/5 left-1/2 -translate-x-1/2 ">
                <Outlet />
            </div>
        </main>
    );
}
