import { Component } from '@angular/core';
import { AuthButtonComponent } from './auth-button/auth-button.component';
import { ThemeSwitchComponent } from '../../features/dark-mode/ui/theme-switch/theme-switch.component';

@Component({
    selector: 'app-header',
    imports: [AuthButtonComponent, ThemeSwitchComponent],
    templateUrl: './header.component.html',
})
export class HeaderComponent {}
