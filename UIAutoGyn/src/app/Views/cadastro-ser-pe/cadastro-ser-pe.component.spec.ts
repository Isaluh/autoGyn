import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroSerPeComponent } from './cadastro-ser-pe.component';

describe('CadastroSerPeComponent', () => {
  let component: CadastroSerPeComponent;
  let fixture: ComponentFixture<CadastroSerPeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroSerPeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroSerPeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
