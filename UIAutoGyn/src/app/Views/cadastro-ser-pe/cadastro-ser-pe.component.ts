import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { Pecas, Servicos } from '../../Models/models';

@Component({
  selector: 'cadastroSerPeView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule],
  templateUrl: './cadastro-ser-pe.component.html',
  styleUrl: './cadastro-ser-pe.component.css'
})
export class CadastroSerPeComponent {
  addServico : Servicos = {
    id: null,
    servico: '',
    valor: null
  }
  addPeca : Pecas = {
    id: null,
    codigo: null,
    peca: '',
    sku: null,
    quantidade: null,
    valor: null
  }

  cadastrarServico(){
    // add servico
  }

  cadastrarPeca(){
    // add peca
  }
}
