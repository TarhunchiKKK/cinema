import { CreateHallForm } from "@/entities/halls";
import { useCreateHall } from "./hooks";
import {
    Button,
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger
} from "@/shared/ui";

export function CreateHallModal() {
    const { createHall, isPending, error } = useCreateHall();

    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline">Создать</Button>
            </DialogTrigger>

            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Создание нового зала</DialogTitle>
                    <DialogDescription>Заполните форму для создания нового зала</DialogDescription>
                </DialogHeader>

                <CreateHallForm submitFn={createHall} error={error} isPending={isPending} />
            </DialogContent>
        </Dialog>
    );
}
