import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {NgIf} from "@angular/common";
import {CreateAccountService} from "../data-access/create-account.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-account-ui',
  standalone: true,
  imports: [
    FormsModule,
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    NgIf
  ],
  templateUrl: './create-account-ui.component.html',
  styleUrl: './create-account-ui.component.css'
})
export class CreateAccountUiComponent {

  constructor(private createAccountService: CreateAccountService, private router: Router) {}

  email: string = "";
  password: string = "";
  name: string = "";
  showWarning: boolean = false;

  public createAccount() {
    if (this.email != "" && this.password != "" && this.name != "") {
      this.createAccountService.createAccount(this.email, this.password, this.name).subscribe(resp => {
        this.router.navigateByUrl("login");
      }, error => {
        this.showWarning = true;
      })
    }
  }

}
