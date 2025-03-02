import { SignUpEmployeeForm, SignUpVisitorForm } from "@/features/auth";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/shared/ui";

export function SignUpPage() {
    return (
        <Tabs defaultValue="visitor" className="w-[300px] sm:w-[400px]">
            <TabsList className="grid w-full grid-cols-2">
                <TabsTrigger value="visitor">Посетитель</TabsTrigger>
                <TabsTrigger value="employee">Сотрудник</TabsTrigger>
            </TabsList>
            <TabsContent value="visitor">
                <SignUpVisitorForm />
            </TabsContent>
            <TabsContent value="employee">
                <SignUpEmployeeForm />
            </TabsContent>
        </Tabs>
    );
}
