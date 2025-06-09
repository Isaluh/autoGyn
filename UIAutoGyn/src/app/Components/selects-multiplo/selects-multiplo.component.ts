import { NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'SelectsMultiploComponent',
  standalone: true,
  imports: [NgIf, NgFor],
  templateUrl: './selects-multiplo.component.html',
  styleUrl: './selects-multiplo.component.css'
})
export class SelectsMultiploComponent {
  @Input() idSelect = ''
  @Input() placeholder = ''
  @Input() tipo = ''
  @Input() opcoes : any = []
  @Output() opcoesSelectedChange = new EventEmitter<any[]>();

  abrirOpcoes = false
  opcoesSelected : any = []

  addRem(opcao: any) {
    const index = this.opcoesSelected.findIndex((o: any) => o === opcao);
    if (index === -1) {
      this.opcoesSelected.push(opcao);
    } else {
      this.opcoesSelected.splice(index, 1);
    }
    this.opcoesSelectedChange.emit(this.opcoesSelected);
  }
}
