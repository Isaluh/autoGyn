import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiculoMarMoComponent } from './veiculo-mar-mo.component';

describe('VeiculoMarMoComponent', () => {
  let component: VeiculoMarMoComponent;
  let fixture: ComponentFixture<VeiculoMarMoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeiculoMarMoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiculoMarMoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
