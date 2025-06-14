import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'ListagemComCategoriaComponent',
  standalone: true,
  imports: [NgFor, NgIf, CommonModule],
  templateUrl: './listagem-com-categoria.component.html',
  styleUrl: './listagem-com-categoria.component.css'
})
export class ListagemComCategoriaComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() campos : string[] = []
  @Input() itens : any[] = []
}
