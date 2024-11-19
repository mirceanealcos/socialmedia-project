import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAccountUiComponent } from './create-account-ui.component';

describe('CreateAccountUiComponent', () => {
  let component: CreateAccountUiComponent;
  let fixture: ComponentFixture<CreateAccountUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateAccountUiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateAccountUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
