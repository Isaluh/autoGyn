import { Component } from '@angular/core';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { Clientes } from '../../Models/models';
import { PessoasService } from '../../Services/pessoas.service';

@Component({
  selector: 'ClientesView',
  standalone: true,
  imports: [BlocoComponent, BaseComponent, InputsComponent, FormsModule, NgIf],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  secao = ''
  addCliente : Clientes = {
    nome: '',
    email: '',
    logradouro: '',
    complemento: '',
    numero: '',
    cep: '',
    cidade: '',
    uf: '',
    ddd: null,
    telefone: null,
    ddd2: null,
    telefone2: null,
    cnpj: '',
    inscricaoEstadual: '',
    nomeContato: '',
    cpf: '',
    isPJ: false,
    isPF: false
  }

  constructor(private clienteService: PessoasService) { }

  trocarSecao(){
    this.addCliente.isPF = !this.addCliente.isPF; 
    this.addCliente.isPJ = !this.addCliente.isPF;

    if(this.addCliente.isPF){
      this.addCliente.cnpj = ''
      this.addCliente.inscricaoEstadual = ''
      this.addCliente.nomeContato = ''
    }
    else{
      this.addCliente.cpf = ''
    }
  }

  cadastrarCliente(){
    this.clienteService.postCliente(this.addCliente).subscribe({
      next: res => {
        alert('Cliente cadastrado com sucesso!');
        this.addCliente = {
          nome: '',
          email: '',
          logradouro: '',
          complemento: '',
          numero: '',
          cep: '',
          cidade: '',
          uf: '',
          ddd: null,
          telefone: null,
          ddd2: null,
          telefone2: null,
          cnpj: '',
          inscricaoEstadual: '',
          nomeContato: '',
          cpf: '',
          isPJ: false,
          isPF: false
        }
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar cliente.';
        alert(mensagem);
      }
    })
  }
}
