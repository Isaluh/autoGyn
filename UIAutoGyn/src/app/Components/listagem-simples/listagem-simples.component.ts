import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'ListagemSimplesComponent',
  standalone: true,
  imports: [NgFor, CommonModule, NgIf],
  templateUrl: './listagem-simples.component.html',
  styleUrl: './listagem-simples.component.css'
})
export class ListagemSimplesComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() numGap: number = 0
  @Input() itens: any[] = [];
}
