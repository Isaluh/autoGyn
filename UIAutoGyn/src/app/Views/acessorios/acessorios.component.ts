import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { Acessorios } from '../../Models/models';
import { FormsModule } from '@angular/forms';
import { ListagemSimplesComponent } from '../../Components/listagem-simples/listagem-simples.component';
import { AcessoriosService } from '../../Services/acessorios.service';

@Component({
  selector: 'AcessoriosView',
  standalone: true,
  imports: [BaseComponent, InputsComponent, BlocoComponent, FormsModule, ListagemSimplesComponent],
  templateUrl: './acessorios.component.html',
  styleUrl: './acessorios.component.css'
})
export class AcessoriosComponent {
  addAcessorio : Acessorios = {
    id: null,
    descricao: ''
  }
  acessoriosListagem: string[] = [];

  constructor(private acessorioService: AcessoriosService) {}

  ngOnInit(){
    this.pegarAcessorios()
  }
  
  pegarAcessorios() {
    this.acessorioService.getAcessorios().subscribe((res: Acessorios[]) =>{
      this.acessoriosListagem = res.map(item => item.descricao);
    });
  }

  cadastrarAcessorio() {
    this.acessorioService.postAcessorio(this.addAcessorio).subscribe({
      next: res => {
        alert('Acessório cadastrado com sucesso!');
        this.addAcessorio = {
          id: null,
          descricao: ''
        }
        this.pegarAcessorios()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar acessório.';
        alert(mensagem);
      }
    })
  }
}
