import { ROUTES } from "@/shared/constants";
import { createBrowserRouter } from "react-router-dom";

export const router = createBrowserRouter([
    {
        path: ROUTES.HOME,
        element: <h1>Home</h1>,
        children: []
    },
    {
        path: ROUTES.AUTH,
        element: <h1>Authentication</h1>,
        children: [
            {
                path: ROUTES.SIGN_IN,
                element: <h2>Sign In</h2>
            },
            {
                path: ROUTES.SIGN_UP,
                element: <h2>Sign Up</h2>
            }
        ]
    }
]);
