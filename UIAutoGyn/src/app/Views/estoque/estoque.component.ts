import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';

@Component({
  selector: 'EstoqueView',
  standalone: true,
  imports: [BaseComponent, ListagemSemCategoriaComponent],
  templateUrl: './estoque.component.html',
  styleUrl: './estoque.component.css'
})
export class EstoqueComponent {
  campos : string[] = ['Código', 'SKU', 'Quantidade no Estoque', 'Valor Unitário']
}
