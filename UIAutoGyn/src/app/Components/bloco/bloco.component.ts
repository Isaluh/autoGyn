import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ButtonsComponent } from "../buttons/buttons.component";

@Component({
  selector: 'BlocoComponent',
  standalone: true,
  imports: [ButtonsComponent],
  templateUrl: './bloco.component.html',
  styleUrl: './bloco.component.css'
})
export class BlocoComponent {
  @Input() titulo = ''
  @Input() descricao = ''
  @Input() textButton = ''

  @Output() foiClicado = new EventEmitter()

  clicado(event : Event){
    event.preventDefault();
    this.foiClicado.emit()
  }
}
