import { useUpdateHall } from "./hooks";
import { TUpdateHallModalProps } from "./types";
import { Pencil } from "lucide-react";
import {
    Button,
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger
} from "@/shared/ui";
import { UpdateHallForm } from "@/entities/halls";
import { omitId } from "./helpers";

export function UpdateHallModal({ hall }: TUpdateHallModalProps) {
    const { updateHall, isPending, error } = useUpdateHall(hall.id);

    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline">
                    <Pencil size={24} />
                </Button>
            </DialogTrigger>

            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Редактирование зала</DialogTitle>
                    <DialogDescription>Заполните форму для редактирования выбранного зала</DialogDescription>
                </DialogHeader>

                <UpdateHallForm
                    defaultValues={omitId(hall)}
                    submitFn={updateHall}
                    error={error}
                    isPending={isPending}
                />
            </DialogContent>
        </Dialog>
    );
}
