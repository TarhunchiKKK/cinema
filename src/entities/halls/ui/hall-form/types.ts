import { AxiosError } from "axios";
import { TValidationErrors } from "@/shared/types";
import { DefaultValues } from "react-hook-form";

export type TFormState = {
    type: string;

    seatsCount: number;
};

export type THallFormProps<T extends TFormState> = {
    defaultValues: DefaultValues<T>;

    submitFn: (_: T) => unknown;

    isPending?: boolean;

    error: AxiosError<TValidationErrors<T>>;

    buttonText: string;
};
