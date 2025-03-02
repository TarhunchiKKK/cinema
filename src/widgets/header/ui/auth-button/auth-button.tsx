import { ROUTES } from "@/shared/constants";
import { Button } from "@/shared/ui";
import { localStorageService } from "@/shared/utils";
import { useNavigate } from "react-router-dom";

export function AuthButton() {
    const hasToken = localStorageService.token.get() ? true : false;

    const navigate = useNavigate();

    const handleClick = () => {
        if (hasToken) {
            localStorageService.token.remove();
            navigate(ROUTES.AFISHA);
        } else {
            navigate(ROUTES.SIGN_UP);
        }
    };

    return (
        <Button className="block" onClick={handleClick}>
            {hasToken ? "Выйти" : "Войти"}
        </Button>
    );
}
