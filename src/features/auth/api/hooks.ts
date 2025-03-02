import { useMutation, useQuery } from "@tanstack/react-query";
import { QUERY_KEY } from "./constants";
import { getProfile, signIn, signUpEmployee, signUpVisitor } from "@/entities/profiles";
import { localStorageService } from "@/shared/utils";
import { TSignUpEmployeeValidationErrors, TSignUpVisitorValidationErrors, TSignInValidationErrors } from "./types";
import { AxiosError } from "axios";

export function useSignUpEmployee() {
    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEY,
        mutationFn: signUpEmployee,
        onSuccess: response => {
            localStorageService.token.set(response.token);
        }
    });

    return {
        signUpEmployee: mutate,
        isPending,
        error: error as AxiosError<TSignUpEmployeeValidationErrors>
    };
}

export function useSignUpVisitor() {
    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEY,
        mutationFn: signUpVisitor,
        onSuccess: response => {
            localStorageService.token.set(response.token);
        }
    });

    return {
        signUpVisitor: mutate,
        isPending,
        error: error as AxiosError<TSignUpVisitorValidationErrors>
    };
}

export function useSignIn() {
    const { mutate, isPending, error } = useMutation({
        mutationKey: QUERY_KEY,
        mutationFn: signIn,
        onSuccess: response => {
            localStorageService.token.set(response.token);
        }
    });

    return {
        signIn: mutate,
        isPending,
        error: error as AxiosError<TSignInValidationErrors>
    };
}

export function useGetProfile() {
    const { isPending, error } = useQuery({
        queryKey: QUERY_KEY,
        queryFn: async () => {
            try {
                const token = localStorageService.token.get();

                if (!token) {
                    throw new Error("No token found in local storage");
                }

                return getProfile(token);
            } catch (_: unknown) {
                localStorageService.token.remove();
            }
        }
    });

    return { isPending, error };
}
