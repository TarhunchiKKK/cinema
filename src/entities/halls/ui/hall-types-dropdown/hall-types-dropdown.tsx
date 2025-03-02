import { Button, DropdownMenu, DropdownMenuContent, DropdownMenuItem, DropdownMenuTrigger } from "@/shared/ui";
import { THallTypesDropdownProps } from "./types";
import { nullValue, placeholder, hallTypes } from "./constants";

export function HallTypesDropdown({ value, onChange }: THallTypesDropdownProps) {
    const handleChange = (value: string) => {
        const val = value === nullValue ? undefined : value;
        onChange(val);
    };

    return (
        <DropdownMenu>
            <DropdownMenuTrigger asChild>
                <Button className="w-[160px]" variant="outline">
                    {value ?? placeholder}
                </Button>
            </DropdownMenuTrigger>

            <DropdownMenuContent align="end">
                {hallTypes.map((hallType, index) => (
                    <DropdownMenuItem key={index} onClick={() => handleChange(hallType.value)}>
                        {hallType.label}
                    </DropdownMenuItem>
                ))}
            </DropdownMenuContent>
        </DropdownMenu>
    );
}
