import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { Pecas, Servicos } from '../../Models/models';
import { ListagemSimplesComponent } from '../../Components/listagem-simples/listagem-simples.component';
import { PecasService } from '../../Services/pecas.service';
import { ServicosService } from '../../Services/servicos.service';

@Component({
  selector: 'cadastroSerPeView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, ListagemSimplesComponent],
  templateUrl: './cadastro-ser-pe.component.html',
  styleUrl: './cadastro-ser-pe.component.css'
})
export class CadastroSerPeComponent {
  addServico : Servicos = {
    id: null,
    descricao: '',
    valor: null,
    formatado: ''
  }
  addPeca : Pecas = {
    id: null,
    codigo: null,
    descricao: '',
    sku: null,
    quantidadeEstoque: null,
    valorUnitario: null
  }
  servicosListagem: string[] = [];

  constructor(private pecasService: PecasService, private servicosService : ServicosService) {}

  ngOnInit(){
    this.pegarServicos()
  }

  pegarServicos() {
    this.servicosService.getServicos().subscribe((res: Servicos[]) => {
      this.servicosListagem = res.flatMap(s => [
        s.formatado
      ]);
    });
  }

  cadastrarServico(){
    this.servicosService.postServico(this.addServico).subscribe({
      next: res => {
        alert('Serviço cadastrado com sucesso!');
        this.addServico = {
          id: null,
          descricao: '',
          valor: null,
          formatado: ''
        }
        this.pegarServicos()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar serviço.';
        alert(mensagem);
      }
    })
  }

  cadastrarPeca(){
    this.pecasService.postPeca(this.addPeca).subscribe(() => {})
  }
}
