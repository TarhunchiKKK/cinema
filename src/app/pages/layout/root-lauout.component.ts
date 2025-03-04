import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from '../../widgets/header/header.component';

@Component({
    selector: 'app-lauout',
    imports: [RouterOutlet, HeaderComponent],
    templateUrl: './root-lauout.component.html',
})
export class RootLayoutComponent {}
