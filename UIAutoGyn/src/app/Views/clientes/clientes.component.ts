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
    inscricao_estadual: '',
    nomeContato: '',
    cpf: '',
    isPJ: false,
    isPF: false
  }
  tipoPessoa = ''

  constructor(private clienteService: PessoasService) { }

  trocarSecao(){
    if (this.tipoPessoa === 'PF') {
      this.addCliente.cnpj = '';
      this.addCliente.inscricao_estadual = '';
      this.addCliente.nomeContato = '';
      this.addCliente.isPF = true
      this.addCliente.isPJ = false
    } else if (this.tipoPessoa === 'PJ') {
      this.addCliente.cpf = '';
      this.addCliente.isPF = false
      this.addCliente.isPJ = true
    } else{
      this.addCliente.isPF = false
      this.addCliente.isPJ = false
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
          inscricao_estadual: '',
          nomeContato: '',
          cpf: '',
          isPJ: false,
          isPF: false
        }
        this.tipoPessoa = ''
        this.trocarSecao()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar cliente.';
        alert(mensagem);
      }
    })
  }
}
