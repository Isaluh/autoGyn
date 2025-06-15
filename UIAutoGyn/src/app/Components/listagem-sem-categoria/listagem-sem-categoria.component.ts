import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { InputsComponent } from '../inputs/inputs.component';
import { ButtonsComponent } from "../buttons/buttons.component";
import { OsService } from '../../Services/os.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'ListagemSemCategoriaComponent',
  standalone: true,
  imports: [NgFor, NgIf, CommonModule, InputsComponent, ButtonsComponent, FormsModule],
  templateUrl: './listagem-sem-categoria.component.html',
  styleUrl: './listagem-sem-categoria.component.css'
})
export class ListagemSemCategoriaComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() campos : string[] = []
  @Input() itens : any[] = []
  @Input() variant = ''

  itemSelecionado: any = null;
  valorPago = null
  @Output() atualizarOS = new EventEmitter<void>();

  constructor(private osService : OsService){}

  selecionarItem(item: any) {
    if(this.variant == 'os'){
      if(item.dados?.['Status'] != 'Finalizado'){
        this.itemSelecionado = item;
      }
    }
  }

  mudarStatus(status : string){
    const descricao = this.itemSelecionado.descricao;
    const match = descricao.match(/\((\d+)\)/);
    const id = match ? match[1] : null;

    switch (status){
      case "aprovar":
        this.osService.aprovar(id).subscribe({
          next: res => {
            alert('OS aprovada!');
            this.itemSelecionado = null
            this.atualizarOS.emit();
          },
          error: err => {
            const mensagem = err.error?.message || 'Erro ao aprovar OS.';
            alert(mensagem);
          }
        })
        break
      case "pagar":
        if(this.valorPago){
          this.osService.pagar(id, this.valorPago).subscribe({
            next: res => {
              alert('Valor recebido!');
              this.itemSelecionado = null
              this.valorPago = null
              this.atualizarOS.emit();
            },
            error: err => {
              const mensagem = err.error?.message || 'Erro ao pagar OS.';
              alert(mensagem);
            }
          })
        }
        else{
          alert('Insira valor')
        }
        break
      case "cancelar":
        this.osService.cancelar(id).subscribe({
          next: res => {
            alert('OS cancelada!');
            this.itemSelecionado = null
            this.atualizarOS.emit();
          },
          error: err => {
            const mensagem = err.error?.message || 'Erro ao cancelar OS.';
            alert(mensagem);
          }
        })
        break
    }
  }
}
