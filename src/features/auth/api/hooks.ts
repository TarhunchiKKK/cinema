import { useMutation, useQuery } from "@tanstack/react-query";
import { getProfile, signIn, signUpEmployee, signUpVisitor, useProfileStore } from "@/entities/profiles";
import { localStorageService } from "@/shared/utils";
import { TSignUpEmployeeValidationErrors, TSignUpVisitorValidationErrors, TSignInValidationErrors } from "./types";
import { AxiosError } from "axios";
import { useNavigate } from "react-router-dom";
import { QUERY_KEYS, ROUTES } from "@/shared/constants";
import { getProfileData, getSignInRedirectRoute } from "./helpers";

export function useSignUpEmployee() {
    const navigate = useNavigate();

    const setProfile = useProfileStore(state => state.setProfile);

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.AUTH,
        mutationFn: signUpEmployee,
        onSuccess: response => {
            localStorageService.token.set(response.token);
            navigate(ROUTES.EMPLOYEE.INDEX.CREATE(response.profile.id));

            getProfileData(response).then(profileData => {
                setProfile(profileData);
            });
        }
    });

    return {
        signUpEmployee: mutate,
        isPending,
        error: error as AxiosError<TSignUpEmployeeValidationErrors>
    };
}

export function useSignUpVisitor() {
    const navigate = useNavigate();

    const setProfile = useProfileStore(state => state.setProfile);

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.AUTH,
        mutationFn: signUpVisitor,
        onSuccess: response => {
            localStorageService.token.set(response.token);
            navigate(ROUTES.VISITOR.INDEX.CREATE(response.profile.id));

            getProfileData(response).then(profileData => {
                setProfile(profileData);
            });
        }
    });

    return {
        signUpVisitor: mutate,
        isPending,
        error: error as AxiosError<TSignUpVisitorValidationErrors>
    };
}

export function useSignIn() {
    const navigate = useNavigate();

    const setProfile = useProfileStore(state => state.setProfile);

    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEYS.AUTH,
        mutationFn: signIn,
        onSuccess: response => {
            localStorageService.token.set(response.token);
            navigate(getSignInRedirectRoute(response));

            getProfileData(response).then(profileData => {
                setProfile(profileData);
            });
        }
    });

    return {
        signIn: mutate,
        isPending,
        error: error as AxiosError<TSignInValidationErrors>
    };
}

export function useGetProfile() {
    const setProfile = useProfileStore(state => state.setProfile);

    const { isPending, error } = useQuery({
        queryKey: QUERY_KEYS.AUTH,
        queryFn: async () => {
            try {
                const token = localStorageService.token.get();

                if (!token) {
                    throw new Error("No token found in local storage");
                }

                const profile = await getProfile(token);

                getProfileData({ profile, token }).then(profileData => {
                    setProfile(profileData);
                });

                return profile;
            } catch (_: unknown) {
                localStorageService.token.remove();
            }
        }
    });

    return { isPending, error };
}
