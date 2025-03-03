import { Button, Calendar, Popover, PopoverContent, PopoverTrigger } from "@/shared/ui";
import { TSeansDatePickerProps } from "./types";
import { cn } from "@/shared/ui/utils";
import { CalendarIcon } from "lucide-react";

export function SeansdatePicker({ value, onChange }: TSeansDatePickerProps) {
    return (
        <Popover>
            <PopoverTrigger asChild>
                <Button
                    variant={"outline"}
                    className={cn("w-[300px] justify-start text-left font-normal", !value && "text-muted-foreground")}
                >
                    <CalendarIcon className="mr-2 h-4 w-4" />
                    {value ? value.toISOString() : "Выбрать дату"}
                </Button>
            </PopoverTrigger>

            <PopoverContent className="w-auto p-0 shadow-md rounded-sm border-[0.5px] bg-white z-30">
                <Calendar mode="single" selected={value} onSelect={onChange} initialFocus />
            </PopoverContent>
        </Popover>
    );
}
