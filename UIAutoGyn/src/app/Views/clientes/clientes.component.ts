import { Component } from '@angular/core';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'ClientesView',
  standalone: true,
  imports: [BlocoComponent, BaseComponent, InputsComponent, FormsModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  cadastrarCliente(){
    // add cliente
  }
}
