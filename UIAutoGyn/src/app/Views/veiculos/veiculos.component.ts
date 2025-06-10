import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { ListagemSemCategoriaComponent } from '../../Components/listagem-sem-categoria/listagem-sem-categoria.component';
import { VeiculosService } from '../../Services/veiculos.service';
import { Veiculos } from '../../Models/models';

@Component({
  selector: 'app-veiculos',
  standalone: true,
  imports: [BaseComponent, ListagemSemCategoriaComponent],
  templateUrl: './veiculos.component.html',
  styleUrl: './veiculos.component.css'
})
export class VeiculosComponent {
  campos : string[] = ['Placas', 'Marca', 'Modelo', 'Ano do Modelo', 'Ano da Fabricação']

  constructor(private veiculosService : VeiculosService){}

  veiculosListagem: {
    descricao: string;
    dados: { [key: string]: string | number }
  }[] = [];


  ngOnInit(){
    this.pegarVeiculos()
  }

  pegarVeiculos() {
    this.veiculosService.getVeiculos().subscribe((res) => {
      console.log(res)
      // tenho q pegar o cliente e a marca pelo modelo (falta passar pelo DTO)
      // this.veiculosListagem = res.map(v => ({
      //   descricao: v.proprietario?.nomeFormatado ?? 'Desconhecido',
      //   dados: {
      //     'Placa': v.placa,
      //     'Marca': v.marca?.nome ?? '',
      //     'Modelo': v.modelo?.nome ?? '',
      //     'Ano do Modelo': v.anoModelo,
      //     'Ano da Fabricação': v.anoFabricacao
      //   }
      // }));
    });
  }



}
