import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemSimplesComponent } from './listagem-simples.component';

describe('ListagemSimplesComponent', () => {
  let component: ListagemSimplesComponent;
  let fixture: ComponentFixture<ListagemSimplesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListagemSimplesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListagemSimplesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
