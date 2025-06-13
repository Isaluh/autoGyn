import { Component, ViewChild } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';
import { VeiculosService } from '../../Services/veiculos.service';
import { Clientes, Marcas, Modelos, Veiculos } from '../../Models/models';
import { PessoasService } from '../../Services/pessoas.service';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { ButtonsComponent } from "../../Components/buttons/buttons.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-veiculos',
  standalone: true,
  imports: [BaseComponent, ListagemSemCategoriaComponent, BlocoComponent, SelectsComponent, InputsComponent, FormsModule, ButtonsComponent, CommonModule],
  templateUrl: './veiculos.component.html',
  styleUrl: './veiculos.component.css'
})
export class VeiculosComponent {
  addVeiculo: Veiculos = {
    id: null,
    placa: '',
    idCliente: null,
    anoFabricacao: null,
    anoModelo: null,
    idModelo: null,
    km: null
  }

  clientes : Clientes[] = []
  marcas : Marcas[] = []
  modelos : Modelos[] = []
  campos : string[] = ['Placa', 'Marca', 'Modelo', 'Ano do Modelo', 'Ano da Fabricação']
  saiu = false;
  mostrarTelaInicial = true;
  @ViewChild(SelectsComponent) selectsComponent!: SelectsComponent;

  constructor(private veiculosService : VeiculosService, private clienteService: PessoasService){}

  veiculosListagem: {
    descricao: string;
    dados: { [key: string]: string | number | null }
  }[] = [];

  ngOnInit(){
    this.pegarVeiculos()
    this.pegarInfos()
    const jaViu = localStorage.getItem('jaViuIntro');
    this.mostrarTelaInicial = !jaViu;
  }

  iniciar() {
    this.saiu = true;
    localStorage.setItem('jaViuIntro', 'true');

    setTimeout(() => {
      this.mostrarTelaInicial = false;
    }, 1000); 
  }

  pegarInfos(){
    this.clienteService.getClientes().subscribe((cli) => this.clientes = cli)
    this.veiculosService.getMarcas().subscribe((m) => this.marcas = m)
  }

  pegarVeiculos() {
    this.veiculosService.getVeiculos().subscribe((res) => {
      this.veiculosListagem = res.map(v => ({
        descricao: v.proprietario?.nomeFormatado ?? 'Desconhecido',
        dados: {
          'Placa': v.placa,
          'Marca': v.marca?.nome ?? '',
          'Modelo': v.modelo?.nome ?? '',
          'Ano do Modelo': v.anoModelo,
          'Ano da Fabricação': v.anoFabricacao
        }
      }));
      console.log(this.veiculosListagem)
    });
  }

  procurarModelos(idMarca: number) {
    this.veiculosService.getModelos().subscribe(todosModelos => {
    this.veiculosService.getMarcasEModelos().subscribe(todasMarcas => {
      const marca = todasMarcas.find(m => m.id == idMarca);
      if (!marca) {
        this.modelos = [];
        return;
      }

      this.modelos = marca.nomeModelos.map(nomeModelo => {
        const modeloEncontrado = todosModelos.find(m => m.nome === nomeModelo);
        return modeloEncontrado
          ? { 
              id: modeloEncontrado.id, 
              nome: modeloEncontrado.nome,
              marca: {}
            }
          : null;
      }).filter(m => m !== null) as Modelos[];
    });
  });
  }

  cadastrarVeiculo() {
    this.veiculosService.postVeiculo(this.addVeiculo).subscribe({
      next: res => {
        alert('Veículo cadastrado com sucesso!');
        this.addVeiculo = {
          id: null,
          placa: '',
          idCliente: null,
          anoFabricacao: null,
          anoModelo: null,
          idModelo: null,
          km: null
        };
        if (this.selectsComponent) {
          this.selectsComponent.limparSelecao();
        }
        this.pegarVeiculos()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar veículo.';
        alert(mensagem);
      }
    });
  }
}
