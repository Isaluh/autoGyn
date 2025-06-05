import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemSemCategoriaComponent } from './listagem-sem-categoria.component';

describe('ListagemSemCategoriaComponent', () => {
  let component: ListagemSemCategoriaComponent;
  let fixture: ComponentFixture<ListagemSemCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListagemSemCategoriaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListagemSemCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
