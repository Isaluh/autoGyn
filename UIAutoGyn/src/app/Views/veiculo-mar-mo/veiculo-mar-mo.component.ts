import { Component, model } from '@angular/core';
import { BaseComponent } from "../../Layouts/base/base.component";
import { BlocoComponent } from "../../Components/bloco/bloco.component";
import { InputsComponent } from "../../Components/inputs/inputs.component";
import { MarcaComModelos, Marcas, Modelos } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { SelectsComponent } from '../../Components/selects/selects.component';
import { ListagemComCategoriaComponent } from '../../Components/listagem-com-categoria/listagem-com-categoria.component';
import { VeiculosService } from '../../Services/veiculos.service';

@Component({
  selector: 'veiculoMarMoView',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, SelectsComponent, ListagemComCategoriaComponent],
  templateUrl: './veiculo-mar-mo.component.html',
  styleUrl: './veiculo-mar-mo.component.css'
})
export class VeiculoMarMoComponent {
  addMarca : Marcas = {
    id: null,
    nome: ''
  }
  addModelo : Modelos = {
    id: null,
    marca: {
      id: null,
      nome: ''
    },
    nome: ''
  }
  marcas : Marcas[] = []
  listagemMarcaModelo: MarcaComModelos[] = []
  valorSelect: any = "";

  constructor(private veiculosService: VeiculosService) {}

  ngOnInit(){
    this.pegarMarcasEModeLos()
  }

  pegarMarcasEModeLos() {
    this.veiculosService.getMarcasEModelos().subscribe(res => {
      this.listagemMarcaModelo = res;

      this.marcas = res.map(item => ({
        id: item.id,
        nome: item.nomeMarca
      }));
    });
  }

  cadastrarMarca(){
    this.veiculosService.postMarca(this.addMarca).subscribe({
      next: res => {
        alert('Marca cadastrada com sucesso!');
        this.addMarca = {
          id: null,
          nome: ''
        }
        this.pegarMarcasEModeLos()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar marca.';
        alert(mensagem);
      }
    })
  }

  cadastrarModelo(){
    const modeloParaEnvio = {
      marcaId: this.addModelo.marca.id,
      nome: this.addModelo.nome
    };

    this.veiculosService.postModelo(modeloParaEnvio).subscribe({
      next: res => {
        alert('Modelo cadastrado com sucesso!');
        this.addModelo = {
          id: null,
          marca: {
            id: null,
            nome: ''
          },
          nome: ''
        }
        this.valorSelect = "";
        this.pegarMarcasEModeLos();
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar modelo.';
        alert(mensagem);
      }
    });
  }

}
