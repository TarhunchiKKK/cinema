import { useForm } from "react-hook-form";
import { defaultvalues, formFields } from "./constants";
import { FormField, Form, FormItem, FormLabel, FormControl, Input, FormDescription, Button } from "@/shared/ui";
import { AuthWrapper } from "../auth-wrapper";
import { TSignInDto } from "@/entities/profiles";
import { ROUTES } from "@/shared/constants";
import { useSignIn } from "../../api";

export function SignInForm() {
    const form = useForm<TSignInDto>({
        defaultValues: defaultvalues
    });

    const { signIn, isPending, error } = useSignIn();

    const onSubmit = (values: TSignInDto) => {
        signIn(values);
    };

    return (
        <AuthWrapper
            heading="Вход"
            description="Чтобы войти на сайт введите ваше имя и пароль"
            backButtonLabel="Нет аккаунта? Создать"
            backButtonHref={ROUTES.AUTH.SIGN_UP}
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
                        Войти
                    </Button>
                </form>
            </Form>
        </AuthWrapper>
    );
}
