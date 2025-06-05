import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectsMultiploComponent } from './selects-multiplo.component';

describe('SelectsMultiploComponent', () => {
  let component: SelectsMultiploComponent;
  let fixture: ComponentFixture<SelectsMultiploComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelectsMultiploComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelectsMultiploComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
