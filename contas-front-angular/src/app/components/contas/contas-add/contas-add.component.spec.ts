import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContasAddComponent } from './contas-add.component';

describe('ContasAddComponent', () => {
  let component: ContasAddComponent;
  let fixture: ComponentFixture<ContasAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContasAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContasAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
