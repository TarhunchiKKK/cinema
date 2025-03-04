import { Component } from '@angular/core';
import { localStorageService } from '../../../shared/utils';
import { Router } from '@angular/router';
import { ROUTES } from '../../../shared/constants';
import { ButtonComponent } from '../../../shared/ui/button/button.component';

@Component({
    selector: 'app-auth-button',
    imports: [ButtonComponent],
    templateUrl: './auth-button.component.html',
})
export class AuthButtonComponent {
    public hasToken = Boolean(localStorageService.token.get());

    public constructor(private router: Router) {}

    public onClick() {
        console.log('click');
        if (this.hasToken) {
            localStorageService.token.remove();
            this.router.navigate([ROUTES.INDEX]);
        } else {
            this.router.navigate([ROUTES.AUTH.SIGN_IN]);
        }
    }
}
