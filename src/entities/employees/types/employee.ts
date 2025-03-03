import { TProfile } from "@/entities/profiles";
import { TSeans } from "@/entities/seanses";
import { TId } from "@/shared/types";

export type TEmployee = {
    id: TId;

    fio: string;

    post: string;

    experience: number;

    profile: TProfile;

    seanses: TSeans[];
};
