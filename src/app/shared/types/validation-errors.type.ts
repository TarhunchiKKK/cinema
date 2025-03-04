export type TValidationErrors<T> = {
    [Key in keyof T]?: string;
};
