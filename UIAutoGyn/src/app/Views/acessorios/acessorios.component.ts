import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { Acessorios } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { ListagemSimplesComponent } from '../../Components/listagem-simples/listagem-simples.component';

@Component({
  selector: 'AcessoriosView',
  standalone: true,
  imports: [BaseComponent, InputsComponent, BlocoComponent, FormsModule, ListagemSimplesComponent],
  templateUrl: './acessorios.component.html',
  styleUrl: './acessorios.component.css'
})
export class AcessoriosComponent {
  addAcessorio : Acessorios = {
    id: null,
    acessorio: ''
  }

  cadastrarAcessorio(){
    // add acessorio
  }
}
