import { TProfile, useProfileStore } from "@/entities/profiles";
import { NavigationMenu, NavigationMenuItem, NavigationMenuLink, NavigationMenuList } from "@/shared/ui";
import { NavLink, Outlet } from "react-router-dom";
import { getNavigationLinks } from "./constants";

export function VisitorLayout() {
    const profile = useProfileStore(state => state.profile) as TProfile;

    return (
        <>
            <div className="mb-4">
                <NavigationMenu>
                    <NavigationMenuList>
                        {getNavigationLinks(profile.id).map((link, index) => (
                            <NavigationMenuItem key={index}>
                                <NavLink
                                    to={link.href}
                                    className={({ isActive }) => (isActive ? "bg-accent text-accent-foreground" : "")}
                                >
                                    <NavigationMenuLink>{link.label}</NavigationMenuLink>
                                </NavLink>
                            </NavigationMenuItem>
                        ))}
                    </NavigationMenuList>
                </NavigationMenu>
            </div>

            <Outlet />
        </>
    );
}
