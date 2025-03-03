import { TSignUpVisitorDto } from "@/entities/profiles";
import { useForm } from "react-hook-form";
import { defaultValues, formFields } from "./constants";
import { useSignUpVisitor } from "../../api";
import { AuthWrapper } from "../auth-wrapper";
import { ROUTES } from "@/shared/constants";
import { Button, Form, FormControl, FormDescription, FormField, FormItem, FormLabel, Input } from "@/shared/ui";

export function SignUpVisitorForm() {
    const form = useForm<TSignUpVisitorDto>({
        defaultValues: defaultValues
    });

    const { signUpVisitor, isPending, error } = useSignUpVisitor();

    const onSubmit = (values: TSignUpVisitorDto) => {
        signUpVisitor(values);
    };

    return (
        <AuthWrapper
            heading="Регистрация"
            description="Введите необходимые поля для регистрации"
            backButtonLabel="Уже есть аккаунт? Войти"
            backButtonHref={ROUTES.AUTH.SIGN_IN}
        >
            <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                    {formFields.map(formField => (
                        <FormField
                            key={formField.name}
                            control={form.control}
                            name={formField.name}
                            render={({ field }) => (
                                <FormItem>
                                    <FormLabel>{formField.label}</FormLabel>

                                    <FormControl>
                                        <Input {...field} type={formField.type} placeholder={formField.placeholder} />
                                    </FormControl>

                                    {error?.response?.data[formField.name] && (
                                        <FormDescription className="text-red-400">
                                            {error.response?.data[formField.name]}
                                        </FormDescription>
                                    )}
                                </FormItem>
                            )}
                        ></FormField>
                    ))}

                    <Button type="submit" disabled={isPending} className="w-full">
                        Создать аккаунт
                    </Button>
                </form>
            </Form>
        </AuthWrapper>
    );
}
