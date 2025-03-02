import { createBrowserRouter } from "react-router-dom";
import { ROUTES } from "@/shared/constants";
import { AfishaPage, AuthLayout, HallsPage, RootLayout, SignInPage, SignUpPage } from "@/pages";

export const router = createBrowserRouter([
    {
        path: ROUTES.ROOT,
        element: <RootLayout />,
        children: [
            {
                path: ROUTES.AFISHA,
                element: <AfishaPage />
            },
            {
                path: ROUTES.HALLS,
                element: <HallsPage />
            }
        ]
    },
    {
        path: ROUTES.AUTH,
        element: <AuthLayout />,
        children: [
            {
                path: ROUTES.SIGN_UP,
                index: true,
                element: <SignUpPage />
            },
            {
                path: ROUTES.SIGN_IN,
                element: <SignInPage />
            }
        ]
    }
]);
