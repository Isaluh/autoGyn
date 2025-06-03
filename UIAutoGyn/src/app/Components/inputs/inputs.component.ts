import { Component, forwardRef, Input } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

@Component({
  selector: 'InputsComponent',
  standalone: true,
  imports: [],
  templateUrl: './inputs.component.html',
  styleUrl: './inputs.component.css',
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputsComponent),
      multi: true
    }
  ]
})
export class InputsComponent implements ControlValueAccessor {
  @Input() tipoInput = ''
  @Input() text = ''
  @Input() idInput = ''
  @Input() placeholder = ''

  valor: string | number = '';

  onChange = (valor: any) => {};
  onTouched = () => {};

  writeValue(value: any): void {
    this.valor = value;
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
  }

  handleInput(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.valor = input.value;
    this.onChange(this.valor);
    this.onTouched();
  }
}
