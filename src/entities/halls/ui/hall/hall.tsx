import { Card, CardContent, CardFooter } from "@/shared/ui";
import { THallProps } from "./types";
import { HallPlaceholder } from "@/assets";

export function Hall({ hall }: THallProps) {
    return (
        <Card>
            <CardContent className="rounded-sm mb-4">
                <img src={HallPlaceholder} alt={hall.type} />
            </CardContent>

            <CardFooter className="block">
                <h4 className="font-bold text-base leading-6 text-white">{hall.type}</h4>

                <p className="font-medium text-base leading-6 text-[#AFB2B6]">{`Мест - ${hall.seatsCount}`}</p>
            </CardFooter>
        </Card>
    );
}
