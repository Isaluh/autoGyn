import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'SelectsComponent',
  standalone: true,
  imports: [NgFor],
  templateUrl: './selects.component.html',
  styleUrl: './selects.component.css'
})
export class SelectsComponent {
  @Input() idSelect = ''
  @Input() placeholder = ''
  @Input() opcoes : any = []

  @Output() selecionado = new EventEmitter();

  onChange(valor: any) {
    this.selecionado.emit(valor.value);
  }
}
