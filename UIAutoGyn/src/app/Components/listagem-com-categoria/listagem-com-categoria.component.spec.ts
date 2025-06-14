import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemComCategoriaComponent } from './listagem-com-categoria.component';

describe('ListagemComCategoriaComponent', () => {
  let component: ListagemComCategoriaComponent;
  let fixture: ComponentFixture<ListagemComCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListagemComCategoriaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListagemComCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
