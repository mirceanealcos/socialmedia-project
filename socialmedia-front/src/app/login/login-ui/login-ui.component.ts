import {ChangeDetectionStrategy, Component, signal} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-login-ui',
  standalone: true,
  imports: [
    MatFormField,
    MatSelect,
    MatOption,
    MatInput,
    MatLabel,
    MatButton,
    MatIconButton,
    MatIcon
  ],
  templateUrl: './login-ui.component.html',
  styleUrl: './login-ui.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoginUiComponent {
  hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }
}
