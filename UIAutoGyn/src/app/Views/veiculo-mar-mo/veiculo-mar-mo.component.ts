import { Component } from '@angular/core';
import { BaseComponent } from "../../Layouts/base/base.component";
import { BlocoComponent } from "../../Components/bloco/bloco.component";
import { InputsComponent } from "../../Components/inputs/inputs.component";
import { Marcas, Modelos } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { SelectsComponent } from '../../Components/selects/selects.component';

@Component({
  selector: 'veiculoMarMoView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, SelectsComponent],
  templateUrl: './veiculo-mar-mo.component.html',
  styleUrl: './veiculo-mar-mo.component.css'
})
export class VeiculoMarMoComponent {
  addMarca : Marcas = {
    id: null,
    marca: ''
  }
  addModelo : Modelos = {
    id: null,
    marca: {},
    modelo: ''
  }

  cadastrarMarca(){
    // add marca
  }

  cadastrarModelo(){
    // add modelo
  }
}
