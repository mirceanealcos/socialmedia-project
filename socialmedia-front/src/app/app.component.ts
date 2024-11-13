import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatFormField} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    MatFormField,
    MatSelect,
    MatOption,
    MatInput],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'socialmedia-front';
}
