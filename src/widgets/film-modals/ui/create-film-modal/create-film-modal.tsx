import { CreateFilmForm } from "@/entities/films";
import {
    Button,
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger
} from "@/shared/ui";
import { useCreateFilm } from "./hooks";

export function CreateFilmModal() {
    const { createFilm, isPending, error } = useCreateFilm();

    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline">Создать</Button>
            </DialogTrigger>

            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Создание нового фильма</DialogTitle>
                    <DialogDescription>Заполните форму для создания нового фильма</DialogDescription>
                </DialogHeader>

                <CreateFilmForm submitFn={createFilm} error={error} isPending={isPending} />
            </DialogContent>
        </Dialog>
    );
}
