import { Component } from '@angular/core';
import { BaseComponent } from "../../Layouts/base/base.component";
import { BlocoComponent } from "../../Components/bloco/bloco.component";
import { InputsComponent } from "../../Components/inputs/inputs.component";
import { Veiculos } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { SelectsMultiploComponent } from '../../Components/selects-multiplo/selects-multiplo.component';

interface Veiculo{
  proprietario: {},
  placa: string,
  kms: number | null
}

@Component({
  selector: 'VeiculoCadAtView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, SelectsComponent, SelectsMultiploComponent],
  templateUrl: './veiculoCadAt.component.html',
  styleUrl: './veiculoCadAt.component.css'
})
export class VeiculoCadAtComponent {
  addVeiculo: Veiculos = {
    id: null,
    proprietario: {},
    placa: '',
    anoFabricacao: null,
    anoModelo: null,
    marca: {},
    modelo: {},
    kms: null,
    numChassi: null,
    numPatrimonio: null,
    acessorios: []
  }

  attVeiculo: Veiculo = {
    proprietario: {},
    placa: '',
    kms: null
  }

  cadastrarVeiculo(){
    // mandar o add veiculo
  }

  atualizarVeiculo(){
    // mandar o att veiculo (busca pela placa)
  }
}
