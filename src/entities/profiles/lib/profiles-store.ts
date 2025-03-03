import { create } from "zustand";
import { TVisitor } from "@/entities/visitors";
import { TEmployee } from "@/entities/employees";
import { TSeans } from "@/entities/seanses";

type TProfileStore = {
    profile: TVisitor | TEmployee | null;

    setProfile: (_: TVisitor | TEmployee) => void;

    resetProfile: () => void;

    toggleSeans: (_: TSeans) => void;
};

export const useProfileStore = create<TProfileStore>(set => ({
    profile: null,
    setProfile: (profile: TVisitor | TEmployee) => set(() => ({ profile })),
    resetProfile: () => set(() => ({ profile: null })),
    toggleSeans: (seans: TSeans) =>
        set(state => {
            const exist = state.profile!.seanses.find(s => s.id === seans.id);
            const nextSeanses = exist
                ? state.profile!.seanses.filter(s => s.id !== seans.id)
                : [...state.profile!.seanses, seans];
            const nextState = { ...state };
            nextState.profile!.seanses = nextSeanses;
            return nextState;
        })
}));
