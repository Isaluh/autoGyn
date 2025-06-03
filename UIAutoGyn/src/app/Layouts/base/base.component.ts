import { NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'BaseLayout',
  standalone: true,
  imports: [RouterLinkActive, RouterLink, NgIf],
  templateUrl: './base.component.html',
  styleUrl: './base.component.css'
})
export class BaseComponent {
  @Input() opcoesVeiculo = false
  @Input() opcoesOS = false
}
