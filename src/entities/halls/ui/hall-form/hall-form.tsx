import { FieldValues, Path, useForm } from "react-hook-form";
import { TFormState, THallFormProps } from "./types";
import { Button, Form, FormControl, FormDescription, FormField, FormItem, FormLabel, Input } from "@/shared/ui";
import { HallTypesDropdown } from "../hall-types-dropdown";
import { bindProps } from "@/shared/utils";

function HallForm<T extends FieldValues & TFormState>({
    defaultValues,
    error,
    submitFn,
    isPending,
    buttonText
}: THallFormProps<T>) {
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
                    name={"type" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Тип зала:</FormLabel>

                            <FormControl>
                                <HallTypesDropdown {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />

                <FormField
                    name={"seatsCount" as Path<T>}
                    control={form.control}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Количество мест:</FormLabel>

                            <FormControl>
                                <Input {...field} type="number" placeholder="Сколько мест?" />
                            </FormControl>

                            {error?.response?.data.seatsCount && (
                                <FormDescription className="text-red-400">
                                    {error.response?.data.seatsCount}
                                </FormDescription>
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

export const CreateHallForm = bindProps(HallForm, {
    buttonText: "Создать",
    defaultValues: {
        type: undefined,
        seatsCount: 0
    }
});

export const UpdateHallForm = bindProps(HallForm, {
    buttonText: "Изменить"
});
