import { TValidationErrors } from "@/shared/types";
import { AxiosError } from "axios";
import { DefaultValues } from "react-hook-form";

export type TFormState = {
    title: string;

    year: number;

    country: string;
};

export type TFilmFormProps<T extends TFormState> = {
    defaultValues: DefaultValues<T>;

    submitFn: (_: T) => unknown;

    isPending?: boolean;

    error: AxiosError<TValidationErrors<T>>;

    buttonText: string;
};
