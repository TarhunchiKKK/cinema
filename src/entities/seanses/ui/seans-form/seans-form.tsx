import { FieldValues, Path, useForm } from "react-hook-form";
import { TFormState, TSeansFormProps } from "./types";
import { Button, Form, FormControl, FormDescription, FormField, FormItem, FormLabel, Input } from "@/shared/ui";
import { SeansdatePicker } from "../seans-date-picker";
import { bindProps } from "@/shared/utils";

function SeansForm<T extends FieldValues & TFormState>({
    defaultValues,
    error,
    submitFn,
    isPending,
    buttonText
}: TSeansFormProps<T>) {
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
                    name={"date" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Дата:</FormLabel>

                            <FormControl>
                                <SeansdatePicker {...field} />
                            </FormControl>

                            {error?.response?.data.title && (
                                <FormDescription className="text-red-400">{error.response?.data.title}</FormDescription>
                            )}
                        </FormItem>
                    )}
                />

                <FormField
                    name={"price" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Цена:</FormLabel>

                            <FormControl>
                                <Input {...field} type="number" placeholder="Какого года фильм?" />
                            </FormControl>

                            {error?.response?.data.price && (
                                <FormDescription className="text-red-400">{error.response?.data.year}</FormDescription>
                            )}
                        </FormItem>
                    )}
                />

                <FormField
                    name={"duration" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Длительность:</FormLabel>

                            <FormControl>
                                <Input {...field} type="number" placeholder="Какого года фильм?" />
                            </FormControl>

                            {error?.response?.data.price && (
                                <FormDescription className="text-red-400">{error.response?.data.year}</FormDescription>
                            )}
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

export const CreateSeansForm = bindProps(SeansForm, {
    buttonText: "Создать сеанс"
});
