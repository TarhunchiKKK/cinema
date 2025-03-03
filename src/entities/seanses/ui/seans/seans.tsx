import { Card, CardContent, CardFooter } from "@/shared/ui";
import { TSeansProps } from "./types";
import { FilmPlaceholder } from "@/shared/assets";

export function Seans({ seans }: TSeansProps) {
    return (
        <Card>
            <CardContent className="rounded-sm mb-4">
                <img src={FilmPlaceholder} alt={seans.price.toString()} />
            </CardContent>

            <CardFooter className="block">
                <h4 className="font-bold text-base leading-6 text-white">{seans.film.title}</h4>

                <p className="font-medium text-base leading-6 text-[#AFB2B6]">{seans.date.toISOString()}</p>

                <p className="font-medium text-base leading-6 text-[#AFB2B6]">{`${seans.duration} мин.`}</p>
            </CardFooter>
        </Card>
    );
}
