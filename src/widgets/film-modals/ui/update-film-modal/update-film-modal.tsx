import { useUpdateFilm } from "./hooks";
import { TUpdateFilmModalProps } from "./types";
import {
    Button,
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger
} from "@/shared/ui";
import { UpdateFilmForm } from "@/entities/films";
import { omitId } from "./helpers";
import { Pencil } from "lucide-react";

export function UpdateFilmModal({ film }: TUpdateFilmModalProps) {
    const { updateFilm, isPending, error } = useUpdateFilm(film.id);

    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline">
                    <Pencil size={24} />
                </Button>
            </DialogTrigger>

            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Редактирование фильма</DialogTitle>
                    <DialogDescription>Заполните форму для редактирования выбранного фильма</DialogDescription>
                </DialogHeader>

                <UpdateFilmForm
                    defaultValues={omitId(film)}
                    submitFn={updateFilm}
                    error={error}
                    isPending={isPending}
                />
            </DialogContent>
        </Dialog>
    );
}
