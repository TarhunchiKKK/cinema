import { RouterProvider } from "react-router-dom";
import { router } from "./routing/router";
import { useGetProfile } from "@/features/auth/api";

export function App() {
    const { isPending } = useGetProfile();

    if (isPending) {
        return <></>;
    }

    return <RouterProvider router={router} />;
}
