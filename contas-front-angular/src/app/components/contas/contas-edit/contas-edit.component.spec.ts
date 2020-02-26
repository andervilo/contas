import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContasEditComponent } from './contas-edit.component';

describe('ContasEditComponent', () => {
  let component: ContasEditComponent;
  let fixture: ComponentFixture<ContasEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContasEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContasEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
