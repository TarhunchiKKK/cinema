import { Outlet } from "react-router-dom";
import { Header } from "@/widgets/header";

export function RootLayout() {
    return (
        <>
            <Header />

            <main className="py-4">
                <div className="container mx-auto">
                    <Outlet />
                </div>
            </main>
        </>
    );
}
