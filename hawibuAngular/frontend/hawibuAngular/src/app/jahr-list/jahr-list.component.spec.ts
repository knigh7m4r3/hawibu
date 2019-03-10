import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JahrListComponent } from './jahr-list.component';

describe('JahrListComponent', () => {
  let component: JahrListComponent;
  let fixture: ComponentFixture<JahrListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JahrListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JahrListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
