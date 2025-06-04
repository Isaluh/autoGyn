import { Component } from '@angular/core';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { OrdensServico } from '../../Models/models';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { SelectsMultiploComponent } from '../../Components/selects-multiplo/selects-multiplo.component';

@Component({
  selector: 'app-gerenc-os',
  standalone: true,
  imports: [BlocoComponent, BaseComponent, InputsComponent, FormsModule, SelectsComponent, SelectsMultiploComponent],
  templateUrl: './gerenc-os.component.html',
  styleUrl: './gerenc-os.component.css'
})
export class GerencOsComponent {
  addOS : OrdensServico = {
    id: null,
    veiculo: {},
    servico: [],
    peca: [],
    orcamento: null
  }

  cadastrarOS(){
    // add OS
  }
}
