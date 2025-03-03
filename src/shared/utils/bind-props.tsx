import { FC } from "react";

export function bindProps<P extends Record<string, unknown>, K extends keyof P>(
    Component: FC<P>,
    partial: Pick<P, K>
): FC<Omit<P, K>> {
    return (ommited: Omit<P, K>) => {
        return <Component {...(partial as P)} {...ommited} />;
    };
}
