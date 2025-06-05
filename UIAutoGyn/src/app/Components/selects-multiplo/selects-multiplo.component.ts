import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

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

  abrirOpcoes = false
  opcoesSelected : any = []

  addRem(item: string) {
  const index = this.opcoesSelected.indexOf(item);

  if (index !== -1) {
    this.opcoesSelected.splice(index, 1);
  } else {
    this.opcoesSelected.push(item);
  }
}

}
