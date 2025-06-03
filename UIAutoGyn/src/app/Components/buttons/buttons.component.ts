import { Component, Input } from '@angular/core';

@Component({
  selector: 'ButtonsComponent',
  standalone: true,
  imports: [],
  templateUrl: './buttons.component.html',
  styleUrl: './buttons.component.css'
})
export class ButtonsComponent {
  @Input() text = ''
  
}
