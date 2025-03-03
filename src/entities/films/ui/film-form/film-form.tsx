import { FieldValues, Path, useForm } from "react-hook-form";
import { Button, Form, FormControl, FormDescription, FormField, FormItem, FormLabel, Input } from "@/shared/ui";
import { TFilmFormProps, TFormState } from "./types";
import { CountriesDropdown } from "../countries-dropdown";
import { bindProps } from "@/shared/utils";

function FilmForm<T extends FieldValues & TFormState>({
    defaultValues,
    error,
    submitFn,
    isPending,
    buttonText
}: TFilmFormProps<T>) {
    const form = useForm<T>({
        defaultValues: defaultValues
    });

    const onSubmit = (values: T) => {
        submitFn(values);
        form.reset();
    };

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                <FormField
                    name={"title" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Название:</FormLabel>

                            <FormControl>
                                <Input {...field} placeholder="Название фильма" />
                            </FormControl>

                            {error?.response?.data.title && (
                                <FormDescription className="text-red-400">{error.response?.data.title}</FormDescription>
                            )}
                        </FormItem>
                    )}
                />

                <FormField
                    name={"year" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Год выпуска:</FormLabel>

                            <FormControl>
                                <Input {...field} type="number" placeholder="Какого года фильм?" />
                            </FormControl>

                            {error?.response?.data.year && (
                                <FormDescription className="text-red-400">{error.response?.data.year}</FormDescription>
                            )}
                        </FormItem>
                    )}
                />

                <FormField
                    name={"country" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Страна:</FormLabel>

                            <FormControl>
                                <CountriesDropdown {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />

                <Button type="submit" disabled={isPending} className="w-full">
                    {buttonText}
                </Button>
            </form>
        </Form>
    );
}

export const CreateFilmForm = bindProps(FilmForm, {
    buttonText: "Создать",
    defaultValues: {
        title: "Новый фильм",
        year: 1990,
        country: undefined
    }
});

export const UpdateFilmForm = bindProps(FilmForm, {
    buttonText: "Изменить"
});
