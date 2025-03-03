import { useFilmSeanses } from "./hooks";
import { SeansListItem } from "../seans-list-item";
import { TSeansesListProps } from "./types";

export function SeansesList({ filmId }: TSeansesListProps) {
    const { seanses } = useFilmSeanses(filmId);

    return (
        <div className="w-[600px]">
            <div className="flex flex-col gap-6">
                {seanses?.map(seans => (
                    <SeansListItem key={seans.id} seans={seans} />
                ))}
            </div>

            {seanses && seanses.length === 0 && (
                <p className="w-full text-center font-bold text-lg leading-7 text-white">Сеансов нет</p>
            )}
        </div>
    );
}
