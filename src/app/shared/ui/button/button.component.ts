import { Component, Input } from '@angular/core';
import { defaultStyle, sizes, types, variants } from './button.constants';

@Component({
    selector: 'app-button',
    imports: [],
    templateUrl: './button.component.html',
})
export class ButtonComponent {
    @Input() variant: keyof typeof variants = 'default';

    @Input() size: keyof typeof sizes = 'default';

    @Input() type: keyof typeof types = 'button';

    @Input() class: string = '';

    @Input() disabled?: boolean;

    @Input() click?: () => void;

    public className: string;

    public constructor() {
        this.className = [defaultStyle, variants[this.variant], sizes[this.size], this.class].join(' ');
    }
}
