import { Component } from '@angular/core';
import { BaseComponent } from '../../Layouts/base/base.component';
import { BlocoComponent } from '../../Components/bloco/bloco.component';
import { InputsComponent } from '../../Components/inputs/inputs.component';
import { FormsModule } from '@angular/forms';
import { Colaboradores } from '../../Models/models';
import { ListagemSimplesComponent } from '../../Components/listagem-simples/listagem-simples.component';
import { PessoasService } from '../../Services/pessoas.service';

@Component({
  selector: 'app-cadastro-colab',
  standalone: true,
  imports: [BaseComponent, BlocoComponent, InputsComponent, FormsModule, ListagemSimplesComponent],
  templateUrl: './cadastro-colab.component.html',
  styleUrl: './cadastro-colab.component.css'
})
export class CadastroColabComponent {
  addColaborador: Colaboradores = {
    id: null,
    nome: '',
    cpf: null
  }
  colaboradoresListagem: string[] = [];

  constructor(private colaboradorService: PessoasService) { }

  ngOnInit(){
    this.pegarColaboradores()
  }

  pegarColaboradores() {
    this.colaboradorService.getColaboradores().subscribe((res) => {
      this.colaboradoresListagem = res.map((c : any) => {
        return c.nomeFormatado;
      });
    });
  }

  cadastrarColaborador() {
    this.colaboradorService.postColaborador(this.addColaborador).subscribe({
      next: res => {
        alert('Colaborador cadastrado com sucesso!');
        this.addColaborador = {
          id: null,
          nome: '',
          cpf: null
        }
        this.pegarColaboradores()
      },
      error: err => {
        const mensagem = err.error?.message || 'Erro inesperado ao cadastrar colaborador.';
        alert(mensagem);
      }
    })
  }
}
