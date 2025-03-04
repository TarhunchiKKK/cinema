import { Component, Input } from '@angular/core';
import { TInputType } from './input.types';
import { defaultStyles } from './input.constants';

@Component({
    selector: 'app-input',
    imports: [],
    templateUrl: './input.component.html',
})
export class InputComponent {
    @Input() class: string = '';

    @Input() type: TInputType = 'text';

    @Input() disabled?: boolean;

    @Input() value?: string;

    @Input() change?: (_: string) => void;

    @Input() placeholder: string = '';

    public className: string;

    public constructor() {
        this.className = [...defaultStyles, this.class].join(' ');
    }
}
