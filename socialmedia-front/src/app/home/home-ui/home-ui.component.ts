import {Component, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {Router} from "@angular/router";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {FormsModule} from "@angular/forms";
import {EmojiService} from "../util/emoji.service";
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {HomeService} from "../data-access/home.service";
import {response} from "express";

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
  editCommentToggle: boolean = false;
  selectedCommentId: number = 0;
  selectedCommentContent: string = "";
  editPostToggle: boolean = false;
  selectedPostId: number = 0;
  selectedPostTitle: string = "";
  selectedPostContent: string = "";
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

  isOwnComment(comment: any) {
    return comment.userId == Number(localStorage.getItem("id"));
  }

  deleteComment(id: number) {
    this.homeService.deleteCommentById(id).subscribe(resp => {
      this.getAllPublishedPosts();
    })
  }

  toggleEditComment(commentId: number, commentContent: string) {
    this.selectedCommentId = commentId;
    this.selectedCommentContent = commentContent;
    this.editCommentToggle = true;
  }

  untoggleEditComment() {
    this.selectedCommentId = 0;
    this.selectedCommentContent = "";
    this.editCommentToggle = false;
  }

  updateComment() {
    if (this.selectedCommentContent != "") {
      this.homeService.updateComment(this.selectedCommentId, this.selectedCommentContent).subscribe(resp => {
        this.selectedCommentContent = "";
        this.selectedCommentId = 0;
        this.editCommentToggle = false;
        this.getAllPublishedPosts();
      })
    }
  }

  isOwnPost(post: any) {
    return post.userId == Number(localStorage.getItem("id"));
  }

  deletePost(postId: number) {
    this.homeService.deletePost(postId).subscribe(resp => {
      this.getAllPublishedPosts();
    })
  }

  toggleEditPost(post: any) {
    this.selectedPostId = post.id;
    this.selectedPostTitle = post.title;
    this.selectedPostContent = post.content;
    this.editPostToggle = true;
  }
  untoggleEditPost() {
    this.selectedPostId = 0;
    this.selectedPostContent = "";
    this.selectedPostTitle = "";
    this.editPostToggle = false;
  }

  updatePost() {
    if (this.selectedPostContent != "" && this.selectedPostTitle != "") {
      this.homeService.updatePost(this.selectedPostId, this.selectedPostContent, this.selectedPostTitle).subscribe(resp => {
        this.selectedPostTitle = "";
        this.selectedPostId = 0;
        this.selectedPostContent = "";
        this.editPostToggle = false;
        this.getAllPublishedPosts();
      })
    }
  }

}
