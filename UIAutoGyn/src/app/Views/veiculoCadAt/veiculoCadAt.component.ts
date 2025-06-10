import { Component } from '@angular/core';
import { BaseComponent } from "../../Layouts/base/base.component";
import { BlocoComponent } from "../../Components/bloco/bloco.component";
import { InputsComponent } from "../../Components/inputs/inputs.component";
import { Acessorios, Clientes, Marcas, Modelos, Veiculos } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { SelectsMultiploComponent } from '../../Components/selects-multiplo/selects-multiplo.component';
import { PessoasService } from '../../Services/pessoas.service';
import { VeiculosService } from '../../Services/veiculos.service';
import { AcessoriosService } from '../../Services/acessorios.service';

interface Veiculo{
  proprietario: {},
  placa: string,
  kms: number | null
}

@Component({
  selector: 'VeiculoCadAtView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, SelectsComponent, SelectsMultiploComponent],
  templateUrl: './veiculoCadAt.component.html',
  styleUrl: './veiculoCadAt.component.css'
})
export class VeiculoCadAtComponent {
  addVeiculo: Veiculos = {
    id: null,
    placa: '',
    idCliente: null,
    anoFabricacao: null,
    anoModelo: null,
    idModelo: null,
    km: null,
    numeroChassi: '',
    numeroPatrimonio: '',
    acessorios: []
  }

  attVeiculo: Veiculo = {
    proprietario: {},
    placa: '',
    kms: null
  }

  clientes : Clientes[] = []
  marcas : Marcas[] = []
  modelos : Modelos[] = []
  acessorios : Acessorios[] = []

  constructor(private clienteService: PessoasService, private veiculosService : VeiculosService, private acessoriosService : AcessoriosService) {}

  ngOnInit(){
    this.pegarInfos()
  }

  pegarInfos(){
    this.clienteService.getClientes().subscribe((cli) => this.clientes = cli)
    this.veiculosService.getMarcas().subscribe((m) => this.marcas = m)
    this.acessoriosService.getAcessorios().subscribe((acess) => this.acessorios = acess)
  }

  procurarModelos(idMarca: number) {
    this.veiculosService.getModelos().subscribe(todosModelos => {
    this.veiculosService.getMarcasEModelos().subscribe(todasMarcas => {
      const marca = todasMarcas.find(m => m.id == idMarca);
      console.log(todasMarcas)
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
    const veiculoParaEnviar = {
      ...this.addVeiculo,
      acessorios: this.addVeiculo.acessorios.map((a: any) => a.id)  // só os IDs
    };

    this.veiculosService.postVeiculo(veiculoParaEnviar).subscribe({
      next: res => {
        alert('Veículo cadastrado com sucesso!');
        this.addVeiculo = {
          id: null,
          placa: '',
          idCliente: null,
          anoFabricacao: null,
          anoModelo: null,
          idModelo: null,
          km: null,
          numeroChassi: '',
          numeroPatrimonio: '',
          acessorios: []
        };
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar veículo.';
        alert(mensagem);
      }
    });
  }


  atualizarVeiculo(){
    // mandar o att veiculo (busca pela placa)
  }
}
