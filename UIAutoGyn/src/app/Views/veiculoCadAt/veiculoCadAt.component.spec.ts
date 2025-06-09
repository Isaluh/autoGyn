import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VeiculoCadAtComponent } from './veiculoCadAt.component';

describe('VeiculosComponent', () => {
  let component: VeiculoCadAtComponent;
  let fixture: ComponentFixture<VeiculoCadAtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeiculoCadAtComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiculoCadAtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
