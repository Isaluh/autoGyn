import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'SelectsComponent',
  standalone: true,
  imports: [NgFor],
  templateUrl: './selects.component.html',
  styleUrl: './selects.component.css'
})
export class SelectsComponent {
  @Input() idSelect = ''
  @Input() placeholder = ''
  @Input() opcoes : any = []
}
