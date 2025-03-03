import { createBrowserRouter } from "react-router-dom";
import { ROUTES } from "@/shared/constants";
import {
    AfishaPage,
    AuthLayout,
    EmployeeLayout,
    EmployeeSeansesPage,
    HallsPage,
    RootLayout,
    SignInPage,
    SignUpPage,
    VisitorLayout
} from "@/pages";

export const router = createBrowserRouter([
    {
        path: ROUTES.INDEX,
        element: <RootLayout />,
        children: [
            {
                path: ROUTES.AFISHA,
                element: <AfishaPage />
            }
        ]
    },
    {
        path: ROUTES.AUTH.INDEX,
        element: <AuthLayout />,
        children: [
            {
                path: ROUTES.AUTH.SIGN_UP,
                index: true,
                element: <SignUpPage />
            },
            {
                path: ROUTES.AUTH.SIGN_IN,
                element: <SignInPage />
            }
        ]
    },
    {
        path: ROUTES.EMPLOYEE.INDEX.PATTERN,
        element: <EmployeeLayout />,
        children: [
            {
                path: ROUTES.EMPLOYEE.FILMS.PATTERN,
                element: <AfishaPage />
            },
            {
                path: ROUTES.EMPLOYEE.SEANSES.PATTERN,
                element: <EmployeeSeansesPage />
            },
            {
                path: ROUTES.EMPLOYEE.HALLS.PATTERN,
                element: <HallsPage />
            }
        ]
    },
    {
        path: ROUTES.VISITOR.INDEX.PATTERN,
        element: <VisitorLayout />,
        children: [
            {
                path: ROUTES.VISITOR.FILMS.PATTERN,
                element: <AfishaPage />
            },
            {
                path: ROUTES.VISITOR.SEANSES.PATTERN,
                element: <VisitorLayout />
            }
        ]
    }
]);
