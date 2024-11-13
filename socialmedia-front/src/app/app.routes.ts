import { Routes } from '@angular/router';
import {LoginUiComponent} from "./login/login-ui/login-ui.component";

export const routes: Routes = [
  {path: 'login', component: LoginUiComponent},
  {path: "", redirectTo: 'login', pathMatch: "full"}
];
