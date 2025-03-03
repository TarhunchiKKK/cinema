import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/shared/ui";
import { TSeansListItemProps } from "./types";
import { ToggleSeansCheckbox } from "../toggle-seans-checkbox";

export function SeansListItem({ seans }: TSeansListItemProps) {
    return (
        <Card className="flex flex-row justify-between items-start">
            <CardHeader className="space-y-2">
                <CardTitle className="text-xl">{seans.date.toISOString()}</CardTitle>

                <CardDescription>
                    <p className="font-medium text-base leading-6 text-[#AFB2B6]">{`${seans.price} $`}</p>
                    <p className="font-medium text-base leading-6 text-[#AFB2B6]">{`${seans.duration} мин.`}</p>
                </CardDescription>
            </CardHeader>

            <CardContent>
                <ToggleSeansCheckbox seans={seans} />
            </CardContent>
        </Card>
    );
}
