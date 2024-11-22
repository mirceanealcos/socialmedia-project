import {ChangeDetectionStrategy, Component, signal} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {FormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../data-access/login.service";
import {NgIf} from "@angular/common";

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
    MatIcon,
    FormsModule,
    NgIf
  ],
  templateUrl: './login-ui.component.html',
  styleUrl: './login-ui.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoginUiComponent {

  email: string = "";
  password: string = "";
  showWarning: boolean = false;

  hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }
  constructor(private router: Router, private loginService: LoginService) {
  }

  login() {
    if (this.email != null && this.email != "" && this.password != null && this.password != '') {
      this.loginService.login(this.email, this.password).subscribe(resp => {
        localStorage.setItem("id", resp.id);
        localStorage.setItem("email", resp.email);
        localStorage.setItem("name", resp.name);
        this.router.navigateByUrl("home");
      }, error => {
        console.log(error);
        this.showWarning = true;
      })
    }
    else {
      this.showWarning = true;
    }
  }

  goToCreateAcc() {
    this.router.navigateByUrl("new");
  }

}
