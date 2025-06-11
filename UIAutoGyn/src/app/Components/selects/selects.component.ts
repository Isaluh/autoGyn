import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'SelectsComponent',
  standalone: true,
  imports: [NgFor, FormsModule],
  templateUrl: './selects.component.html',
  styleUrl: './selects.component.css'
})
export class SelectsComponent {
  @Input() idSelect = '';
  @Input() placeholder = '';
  @Input() opcoes: any[] = [];
  @Input() valorSelecionado: any = '';
  @Output() valorSelecionadoChange = new EventEmitter<any>();

  onChange(value: any) {
    this.valorSelecionadoChange.emit(value);
  }

  limparSelecao() {
    this.valorSelecionado = '';
    this.valorSelecionadoChange.emit(this.valorSelecionado);
  }
}
