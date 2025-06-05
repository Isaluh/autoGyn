import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';
import { PecasService } from '../../Services/pecas.service';
import { Pecas } from '../../Models/models';

@Component({
  selector: 'EstoqueView',
  standalone: true,
  imports: [BaseComponent, ListagemSemCategoriaComponent],
  templateUrl: './estoque.component.html',
  styleUrl: './estoque.component.css'
})
export class EstoqueComponent {

  campos: string[] = ['Código', 'SKU', 'Quantidade no Estoque', 'Valor Unitário'];

  pecas: Pecas[] = [];
  pecasListagem: {
    descricao: string;
    dados: { [key: string]: string | number }
  }[] = [];

  constructor(private pecasService: PecasService) {}

  ngOnInit(): void {
    this.pegarPecas();
  }

  pegarPecas(): void {
    this.pecasService.getPecas().subscribe((res: Pecas[]) => {
      this.pecas = res;

      this.pecasListagem = res.map(p => ({
        descricao: p.descricao,
        dados: {
          'Código': p.codigo ?? '',
          'SKU': p.sku ?? '',
          'Quantidade no Estoque': p.quantidadeEstoque ?? '',
          'Valor Unitário': p.valorUnitario != null ? `R$ ${p.valorUnitario.toFixed(2)}` : ''
        }
      }));
      console.log(this.pecasListagem)
    });
  }
}