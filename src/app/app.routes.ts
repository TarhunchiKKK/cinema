import { Routes } from '@angular/router';
import { ROUTES } from './shared/constants';
import { RootLayoutComponent } from './pages';

export const routes: Routes = [
    {
        path: ROUTES.INDEX,
        component: RootLayoutComponent,
        children: [],
    },
];
