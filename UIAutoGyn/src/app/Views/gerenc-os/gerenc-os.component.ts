import { Component, ViewChild } from '@angular/core';
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
import { OsService } from '../../Services/os.service';

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
  ordensListagem : OrdensServico[] = []

  servicosSelected : any = []

  campos : string[] = ['Veículo', 'Data', 'Valor Total', 'Status']
  @ViewChild(SelectsComponent) selectsComponent!: SelectsComponent;

  veiculosListagem : any = [];


  constructor(private pecasService: PecasService, private servicosService : ServicosService, private veiculosService : VeiculosService, private pessoasServico : PessoasService, private osService : OsService) {}
    
  ngOnInit() {
    this.pegarInfos();
    this.pegarOS()
  }
  
  pegarInfos() {
    this.pecasService.getPecas().subscribe((peca) => this.pecas = peca)
    this.servicosService.getServicos().subscribe((ser) => this.servicos = ser)
    this.veiculosService.getVeiculos().subscribe((res) => {
      this.veiculosListagem = res.map(v => ({
        id: v.placa,
        nomeFormatado: `${v.proprietario?.nomeFormatado ?? 'Desconhecido'} - ${v.placa}`
      }));
    });
    this.pessoasServico.getColaboradores().subscribe((colab) => this.colaboradores = colab)
  }

  pegarOS(){
    this.osService.getOS().subscribe((res) => {
    this.ordensListagem = res.map((os : any) => ({
      descricao: os.cliente,
      dados: {
        'Veículo': os.veiculo,
        'Data': os.data,
        'Valor Total': os.valor,
        'Status': os.status
      }
    }))})
  }
  
  adicionarServico() {
    const novoServico = { servico: null, colaborador: null };
    this.addOS.servicosColaboradores.push(novoServico)
  }

  removerServico(index: number) {
    this.addOS.servicosColaboradores.splice(index, 1);
  }

  cadastrarOS() {
    const osParaEnviar = {
      ...this.addOS,
      peca: this.addOS.peca.map(p => p.id)
    };

    this.osService.postOS(osParaEnviar).subscribe({
      next: res => {
        alert('OS cadastrada com sucesso!');
        this.addOS = {
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
        };
        if (this.selectsComponent) {
          this.selectsComponent.limparSelecao();
        }
        this.pegarOS();
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar OS.';
        alert(mensagem);
      }
    });
  }
}
