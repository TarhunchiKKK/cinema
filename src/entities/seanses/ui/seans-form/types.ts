import { TValidationErrors } from "@/shared/types";
import { AxiosError } from "axios";
import { DefaultValues } from "react-hook-form";

export type TFormState = {
    data: Date;

    price: number;

    duration: number;
};

export type TSeansFormProps<T extends TFormState> = {
    defaultValues: DefaultValues<T>;

    submitFn: (_: T) => unknown;

    isPending?: boolean;

    error: AxiosError<TValidationErrors<T>>;

    buttonText: string;
};
