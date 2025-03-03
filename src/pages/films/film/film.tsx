import { useParams } from "react-router-dom";
import { useFilm } from "./hooks";
import { TId } from "@/shared/types";
import { Film } from "@/entities/films";
import { SeansesList } from "@/widgets/seanses-list";

export function FilmPage() {
    const { filmId } = useParams();

    const { film } = useFilm(filmId as TId);

    return (
        <div className="flex flex-row justify-between items-start">
            <div className="w-[500px]">{film && <Film film={film} disableLink={true} />}</div>

            {film && <SeansesList filmId={film?.id} />}
        </div>
    );
}
