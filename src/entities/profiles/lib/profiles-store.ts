import { create } from "zustand";
import { TProfile } from "../types";

type TProfileStore = {
    profile: TProfile | null;

    setProfile: (_: TProfile) => void;
};

export const useProfileStore = create<TProfileStore>(set => ({
    profile: null,
    setProfile: (profile: TProfile) => set(() => ({ profile }))
}));
