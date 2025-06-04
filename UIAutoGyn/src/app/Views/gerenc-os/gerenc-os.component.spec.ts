import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerencOsComponent } from './gerenc-os.component';

describe('GerencOsComponent', () => {
  let component: GerencOsComponent;
  let fixture: ComponentFixture<GerencOsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GerencOsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GerencOsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
