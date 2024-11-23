import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Overlay} from "@angular/cdk/overlay";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private basePostURL: string = "http://localhost:8080/posts";
  private baseCommentURL: string = "http://localhost:8080/comments";

  constructor(private http: HttpClient) { }

  public getAllPublishedPosts(): Observable<any> {
    return this.http.get(this.basePostURL + "/published");
  }

  public getPendingPostsForLoggedUser(): Observable<any> {
    const userId: number = Number(localStorage.getItem("id"));
    return this.http.get(this.basePostURL + "/pending/user/" + userId);
  }

  public getPublishedPostsForLoggedUser(): Observable<any> {
    const userId: number = Number(localStorage.getItem("id"));
    return this.http.get(this.basePostURL + "/user/" + userId);
  }

  public addComment(content: string, postId: number, userId: number): Observable<any> {
    return this.http.post(this.baseCommentURL, {content: content, postId: postId, userId: userId});
  }

  public addPost(content: string, title: string, userId: number): Observable<any> {
    return this.http.post(this.basePostURL, {title: title, content: content, userId: userId})
  }

  public deleteCommentById(commentId: number): Observable<any> {
    return this.http.delete(this.baseCommentURL + "/" + commentId);
  }

  public updateComment(commentId: number, commentContent: string): Observable<any> {
    return this.http.put(this.baseCommentURL + "/" + commentId, {content: commentContent});
  }

  public deletePost(postId: number): Observable<any> {
    return this.http.delete(this.basePostURL + "/" + postId);
  }

  public updatePost(postId: number, postContent: string, postTitle: string): Observable<any> {
    return this.http.put(this.basePostURL + "/" + postId, {title: postTitle, content: postContent, status: "PENDING"})
  }

}
