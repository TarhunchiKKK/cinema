import { AfishaPage, AuthLayout, RootLayout, SignInPage, SignUpPage } from "@/pages";
import { ROUTES } from "@/shared/constants";
import { createBrowserRouter } from "react-router-dom";

export const router = createBrowserRouter([
    {
        path: ROUTES.ROOT,
        element: <RootLayout />,
        children: [
            {
                path: ROUTES.AFISHA,
                element: <AfishaPage />
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
