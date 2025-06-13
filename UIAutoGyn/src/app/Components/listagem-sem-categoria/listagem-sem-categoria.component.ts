import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { InputsComponent } from '../inputs/inputs.component';
import { ButtonsComponent } from "../buttons/buttons.component";

@Component({
  selector: 'ListagemSemCategoriaComponent',
  standalone: true,
  imports: [NgFor, NgIf, CommonModule, InputsComponent, ButtonsComponent],
  templateUrl: './listagem-sem-categoria.component.html',
  styleUrl: './listagem-sem-categoria.component.css'
})
export class ListagemSemCategoriaComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() campos : string[] = []
  @Input() itens : any[] = []
  @Input() variant = ''

  itemSelecionado: any = null;

  selecionarItem(item: any) {
    this.itemSelecionado = item;
  }
}
