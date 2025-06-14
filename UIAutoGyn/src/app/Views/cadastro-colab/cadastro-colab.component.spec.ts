import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroColabComponent } from './cadastro-colab.component';

describe('CadastroColabComponent', () => {
  let component: CadastroColabComponent;
  let fixture: ComponentFixture<CadastroColabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroColabComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroColabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
