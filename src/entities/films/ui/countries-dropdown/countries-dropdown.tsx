import { DropdownMenu, DropdownMenuTrigger } from "@radix-ui/react-dropdown-menu";
import { countries, nullValue, placeholder } from "./constants";
import { TCountriesDropdownProps } from "./types";
import { Button, DropdownMenuContent, DropdownMenuItem } from "@/shared/ui";

export function CountriesDropdown({ value, onChange }: TCountriesDropdownProps) {
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
                {countries.map((country, index) => (
                    <DropdownMenuItem key={index} onClick={() => handleChange(country.value)}>
                        {country.label}
                    </DropdownMenuItem>
                ))}
            </DropdownMenuContent>
        </DropdownMenu>
    );
}
