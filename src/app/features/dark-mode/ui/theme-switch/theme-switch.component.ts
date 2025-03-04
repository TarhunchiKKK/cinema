import { Component } from '@angular/core';
import { Theme } from './theme-switch.types';
import { localStorageService } from '../../../../shared/utils';
import { ButtonComponent } from '../../../../shared/ui';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { heroMoon, heroSun } from '@ng-icons/heroicons/outline';

@Component({
    selector: 'app-theme-switch',
    imports: [ButtonComponent, NgIcon],
    templateUrl: './theme-switch.component.html',
    viewProviders: [provideIcons({ heroMoon, heroSun })],
})
export class ThemeSwitchComponent {
    public currentTheme: Theme = (localStorageService.theme.get() as Theme) ?? Theme.DARK;

    public constructor() {
        this.setTheme(this.currentTheme);
    }

    private setTheme(theme: Theme) {
        window.document.documentElement.classList.remove('light', 'dark');
        window.document.documentElement.classList.add(theme);
        localStorageService.theme.set(theme);
    }

    public getIcon() {
        return this.currentTheme === Theme.LIGHT ? 'heroMoon' : 'heroSun';
    }

    public onClick() {
        this.currentTheme = this.currentTheme === Theme.LIGHT ? Theme.DARK : Theme.LIGHT;
        this.setTheme(this.currentTheme);
    }
}
