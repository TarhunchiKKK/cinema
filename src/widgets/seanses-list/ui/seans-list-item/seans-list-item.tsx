import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/shared/ui";
import { TSeansListItemProps } from "./types";
import { ToggleSeansCheckbox } from "../toggle-seans-checkbox";
import { ProtectedItem } from "@/features/roles";
import { Role } from "@/entities/profiles";

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

            <ProtectedItem requiredRoles={[Role.ROLE_EMPLOYEE, Role.ROLE_VISITOR]}>
                <CardContent>
                    <ToggleSeansCheckbox seans={seans} />
                </CardContent>
            </ProtectedItem>
        </Card>
    );
}
