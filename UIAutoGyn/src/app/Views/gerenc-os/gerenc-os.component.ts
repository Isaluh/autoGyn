import { Component } from '@angular/core';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { OrdensServico, Pecas, Servicos } from '../../Models/models';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { SelectsMultiploComponent } from '../../Components/selects-multiplo/selects-multiplo.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';
import { PecasService } from '../../Services/pecas.service';
import { ServicosService } from '../../Services/servicos.service';
import { VeiculosService } from '../../Services/veiculos.service';
import { ButtonsComponent } from "../../Components/buttons/buttons.component";
import { PessoasService } from '../../Services/pessoas.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-gerenc-os',
  standalone: true,
  imports: [BlocoComponent, BaseComponent, InputsComponent, FormsModule, SelectsComponent, SelectsMultiploComponent, ListagemSemCategoriaComponent, ButtonsComponent, NgFor],
  templateUrl: './gerenc-os.component.html',
  styleUrl: './gerenc-os.component.css'
})
export class GerencOsComponent {
  addOS : OrdensServico = {
    id: null,
    veiculo: {
      id: null,
      placa: '',
      idCliente: null,
      anoFabricacao: null,
      anoModelo: null,
      idModelo: null,
      km: null
    },
    servicosColaboradores: [],
    peca: [],
    orcamento: null
  }
  pecas: Pecas[] = [];
  servicos : Servicos[] = []
  colaboradores : any[] = []

  servicosSelected : any = []

  campos : string[] = ['Veículo', 'Data', 'Valor Total', 'Status']

  veiculosListagem : any = [];


  constructor(private pecasService: PecasService, private servicosService : ServicosService, private veiculosService : VeiculosService, private pessoasServico : PessoasService) {}
    
  ngOnInit() {
    this.pegarInfos();
  }
  
  pegarInfos() {
    this.pecasService.getPecas().subscribe((peca) => this.pecas = peca)
    this.servicosService.getServicos().subscribe((ser) => {this.servicos = ser; console.log(this.servicos)})
    this.veiculosService.getVeiculos().subscribe((res) => {
      this.veiculosListagem = res.map(v => ({
        id: v.placa,
        nomeFormatado: `${v.proprietario?.nomeFormatado ?? 'Desconhecido'} - ${v.placa}`
      }));
    });
    this.pessoasServico.getColaboradores().subscribe((colab) => this.colaboradores = colab)
  }

  adicionarServico() {
    const novoServico = { servico: null, colaborador: null };
    this.addOS.servicosColaboradores.push(novoServico)
    console.log(this.addOS)
  }

  removerServico(index: number) {
    this.addOS.servicosColaboradores.splice(index, 1);
  }

//   this.ordemService.getTodas().subscribe((res: OrdensServico[]) => {
//   this.ordensListagem = res.map(o => ({
//     descricao: `Ordem ${o.id}`,
//     dados: {
//       'Veículo': `${o.veiculo?.modelo?.nome ?? 'Modelo'} - ${o.veiculo?.placa ?? 'Placa'}`,
//       'Data': this.formatarData(o.data ?? new Date()), // se tiver campo `data`
//       'Valor Total': o.orcamento != null ? `R$ ${o.orcamento.toFixed(2)}` : '',
//       'Status': this.definirStatus(o) // se tiver lógica pra status
//     }
//   }));
// });

  cadastrarOS(){
    // add OS
  }

  teste(sv : any){
    this.servicosSelected = sv
    console.log(this.servicosSelected)
  }
}
