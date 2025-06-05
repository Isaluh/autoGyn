import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'ListagemSemCategoriaComponent',
  standalone: true,
  imports: [NgFor, NgIf, CommonModule],
  templateUrl: './listagem-sem-categoria.component.html',
  styleUrl: './listagem-sem-categoria.component.css'
})
export class ListagemSemCategoriaComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() campos : string[] = []
  @Input() itens : any[] = []
}
