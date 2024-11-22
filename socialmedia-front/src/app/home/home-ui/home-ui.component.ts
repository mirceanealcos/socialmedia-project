import {Component, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {Router} from "@angular/router";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {FormsModule} from "@angular/forms";
import {EmojiService} from "../util/emoji.service";
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {HomeService} from "../data-access/home.service";

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
    NgIf,
    NgForOf
  ],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css'
})
export class HomeUiComponent implements OnInit{

  feed: any[] = [];

  name: any = "";
  addComment: string[] = [];
  addToggle: boolean = true;
  addPostContent: string = "";
  addPostTitle: string = "";
  constructor(private router: Router, private emojiService: EmojiService, private homeService: HomeService) {
    this.name = localStorage.getItem("name");
  }

  ngOnInit() {
    this.getAllPublishedPosts();
  }

  logout() {
    localStorage.setItem("email", "");
    localStorage.setItem("name", "");
    this.router.navigateByUrl("login");
  }

  generateEmoji(): string {
    return this.emojiService.generateEmoji();
  }

  getAllPublishedPosts() {
    this.homeService.getAllPublishedPosts().subscribe(resp => {
      this.feed = resp;
      for (let post of this.feed) {
        post.emoji = this.generateEmoji();
      }
    })
  }

  getPendingPosts() {
    this.homeService.getPendingPostsForLoggedUser().subscribe(resp => {
      this.feed = resp;
      for (let post of this.feed) {
        post.emoji = this.generateEmoji();
      }
    })
  }

  getPublishedPosts() {
    this.homeService.getPublishedPostsForLoggedUser().subscribe(resp => {
      this.feed = resp;
      for (let post of this.feed) {
        post.emoji = this.generateEmoji();
      }
    })
  }

  createComment(postId: number, content: string) {
    if (content != "") {
      this.homeService.addComment(content, postId, Number(localStorage.getItem("id"))).subscribe(resp => {
        this.getAllPublishedPosts();
      })
    }
  }

  addPost() {
    if (this.addPostTitle != "" && this.addPostContent != "") {
      this.homeService.addPost(this.addPostContent, this.addPostTitle, Number(localStorage.getItem("id"))).subscribe(resp => {
        this.addPostTitle = "";
        this.addPostContent = "";
        this.addToggle = !this.addToggle;
      })
    }
  }

  showStatusIfPending(post: any): string {
    if (post.status == "PENDING")
      return "[PENDING]";
    return "";
  }

}
