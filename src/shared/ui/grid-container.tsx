import { PropsWithChildren } from "react";

export function GridContainer({ children }: PropsWithChildren) {
    return <div className="grid grid-cols-4 gap-x-6 gap-y-4">{children}</div>;
}
