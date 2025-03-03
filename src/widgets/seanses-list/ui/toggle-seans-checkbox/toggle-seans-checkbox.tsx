import { Checkbox } from "@/shared/ui";
import { TToggleSeansCheckboxProps } from "./types";
import { useProfileStore } from "@/entities/profiles";
import { useToggleSeans } from "./hooks";

export function ToggleSeansCheckbox({ seans }: TToggleSeansCheckboxProps) {
    const seanses = useProfileStore(state => state.profile!.seanses);

    const { toggleSeans, isPending } = useToggleSeans();

    return (
        <Checkbox
            checked={Boolean(seanses.find(s => s.id === seans.id))}
            onCheckedChange={() => toggleSeans(seans)}
            disabled={isPending}
        />
    );
}
