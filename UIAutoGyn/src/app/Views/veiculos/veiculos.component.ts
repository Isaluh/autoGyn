import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';

@Component({
  selector: 'app-veiculos',
  standalone: true,
  imports: [BaseComponent, ListagemSemCategoriaComponent],
  templateUrl: './veiculos.component.html',
  styleUrl: './veiculos.component.css'
})
export class VeiculosComponent {
  campos : string[] = ['Placas', 'Marca', 'Modelo', 'Ano do Modelo', 'Ano da Fabricação']
}
