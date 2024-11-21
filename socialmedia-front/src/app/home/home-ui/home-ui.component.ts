import {Component} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {Router} from "@angular/router";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {FormsModule} from "@angular/forms";
import {EmojiService} from "../util/emoji.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-home-ui',
  standalone: true,
  imports: [
    MatIcon,
    MatCard,
    MatCardHeader,
    MatCardContent,
    MatCardActions,
    MatCardTitle,
    FormsModule,
    NgIf
  ],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent {

  name: any = "";
  addComment: string = "";
  addToggle: boolean = true;
  constructor(private router: Router, private emojiService: EmojiService) {
    this.name = localStorage.getItem("name");
  }

  logout() {
    localStorage.setItem("email", "");
    localStorage.setItem("name", "");
    this.router.navigateByUrl("login");
  }

  generateEmoji(): string {
    return this.emojiService.generateEmoji();
  }

}
