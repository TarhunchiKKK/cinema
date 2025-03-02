import { PropsWithChildren } from "react";
import { Link } from "react-router-dom";
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter, Button } from "@/shared/ui";
import { TAuthWrapperProps } from "./types";

export function AuthWrapper({
    heading,
    description,
    backButtonLabel,
    backButtonHref,
    children
}: PropsWithChildren<TAuthWrapperProps>) {
    return (
        <Card className="w-[300px] sm:w-[400px]">
            <CardHeader className="space-y-2">
                <CardTitle className="text-xl">{heading}</CardTitle>

                {description && <CardDescription>{description}</CardDescription>}
            </CardHeader>

            <CardContent>{children}</CardContent>

            <CardFooter>
                {backButtonLabel && backButtonHref && (
                    <Button variant="link" className="w-full font-normal">
                        <Link to={backButtonHref}>{backButtonLabel}</Link>
                    </Button>
                )}
            </CardFooter>
        </Card>
    );
}
