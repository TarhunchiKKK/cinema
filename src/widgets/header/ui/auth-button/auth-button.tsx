import { useProfileStore } from "@/entities/profiles";
import { ROUTES } from "@/shared/constants";
import { Button } from "@/shared/ui";
import { localStorageService } from "@/shared/utils";
import { useNavigate } from "react-router-dom";

export function AuthButton() {
    const hasToken = localStorageService.token.get() ? true : false;

    const navigate = useNavigate();

    const resetProfile = useProfileStore(state => state.resetProfile);

    const handleClick = () => {
        resetProfile();
        if (hasToken) {
            localStorageService.token.remove();
            navigate(ROUTES.INDEX);
        } else {
            navigate(ROUTES.AUTH.SIGN_IN);
        }
    };

    return (
        <Button className="block" onClick={handleClick}>
            {hasToken ? "Выйти" : "Войти"}
        </Button>
    );
}
