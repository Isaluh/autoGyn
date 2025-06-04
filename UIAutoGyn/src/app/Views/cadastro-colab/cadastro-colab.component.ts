import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { Colaboradores } from '../../Models/models';

@Component({
  selector: 'app-cadastro-colab',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule],
  templateUrl: './cadastro-colab.component.html',
  styleUrl: './cadastro-colab.component.css'
})
export class CadastroColabComponent {
  addColaborador : Colaboradores = {
    id: null,
    nome: '',
    cpf: null
  }

  cadastrarColaborador(){
    // add colab
  }
}
