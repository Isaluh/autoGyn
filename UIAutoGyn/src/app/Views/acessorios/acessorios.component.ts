import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { Acessorios } from '../../Models/models';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'AcessoriosView',
  standalone: true,
  imports: [BaseComponent, InputsComponent, BlocoComponent, FormsModule],
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
