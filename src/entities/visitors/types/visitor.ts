import { TProfile } from "@/entities/profiles";
import { TSeans } from "@/entities/seanses";
import { TId } from "@/shared/types";

export type TVisitor = {
    id: TId;

    fio: string;

    age: number;

    profile: TProfile;

    seanses: TSeans[];
};
