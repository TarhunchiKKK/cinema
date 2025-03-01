export type ValidationErrors<T> = {
    [Key in keyof T]?: string;
};
