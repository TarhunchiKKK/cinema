import { ProtectedRoute } from "@/features/auth";
import { AuthLayout, SignInPage, SignUpPage } from "@/pages";
import { ROUTES } from "@/shared/constants";
import { createBrowserRouter } from "react-router-dom";

export const router = createBrowserRouter([
    {
        path: ROUTES.HOME,
        element: (
            <ProtectedRoute redirectRoute={ROUTES.AUTH}>
                <h1>Home</h1>
            </ProtectedRoute>
        ),
        children: []
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
