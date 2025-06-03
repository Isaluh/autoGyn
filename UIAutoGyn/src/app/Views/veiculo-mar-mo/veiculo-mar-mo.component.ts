import { Component } from '@angular/core';
import { BaseComponent } from "../../Layouts/base/base.component";
import { BlocoComponent } from "../../Components/bloco/bloco.component";
import { InputsComponent } from "../../Components/inputs/inputs.component";

@Component({
  selector: 'veiculoMarMoView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent],
  templateUrl: './veiculo-mar-mo.component.html',
  styleUrl: './veiculo-mar-mo.component.css'
})
export class VeiculoMarMoComponent {

  cadastrarMarca(){

  }

  cadastrarModelo(){
    
  }
}
