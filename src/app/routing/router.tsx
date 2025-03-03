import { createBrowserRouter } from "react-router-dom";
import { ROUTES } from "@/shared/constants";
import {
    AfishaPage,
    AuthLayout,
    EmployeeLayout,
    EmployeeSeansesPage,
    FilmPage,
    HallsPage,
    RootLayout,
    SignInPage,
    SignUpPage,
    VisitorLayout,
    VisitorSeansesPage
} from "@/pages";
import { ProtectedRoute } from "@/features/roles";
import { Role } from "@/entities/profiles";

export const router = createBrowserRouter([
    {
        path: ROUTES.INDEX,
        element: <RootLayout />,
        children: [
            {
                path: ROUTES.FILMS.AFISHA,
                element: <AfishaPage />
            },
            {
                path: ROUTES.FILMS.ONE_FILM.PATTERN,
                element: <FilmPage />
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
                element: (
                    <ProtectedRoute requiredRoles={[Role.ROLE_EMPLOYEE]} redirectRoute={ROUTES.INDEX}>
                        <AfishaPage />
                    </ProtectedRoute>
                )
            },
            {
                path: ROUTES.EMPLOYEE.SEANSES.PATTERN,
                element: (
                    <ProtectedRoute requiredRoles={[Role.ROLE_EMPLOYEE]} redirectRoute={ROUTES.INDEX}>
                        <EmployeeSeansesPage />
                    </ProtectedRoute>
                )
            },
            {
                path: ROUTES.EMPLOYEE.HALLS.PATTERN,
                element: (
                    <ProtectedRoute requiredRoles={[Role.ROLE_EMPLOYEE]} redirectRoute={ROUTES.INDEX}>
                        <HallsPage />
                    </ProtectedRoute>
                )
            }
        ]
    },
    {
        path: ROUTES.VISITOR.INDEX.PATTERN,
        element: <VisitorLayout />,
        children: [
            {
                path: ROUTES.VISITOR.FILMS.PATTERN,
                element: (
                    <ProtectedRoute requiredRoles={[Role.ROLE_VISITOR]} redirectRoute={ROUTES.INDEX}>
                        <AfishaPage />
                    </ProtectedRoute>
                )
            },
            {
                path: ROUTES.VISITOR.SEANSES.PATTERN,
                element: (
                    <ProtectedRoute requiredRoles={[Role.ROLE_VISITOR]} redirectRoute={ROUTES.INDEX}>
                        <VisitorSeansesPage />
                    </ProtectedRoute>
                )
            }
        ]
    }
]);
