import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl: string = "http://localhost:8080/users/login"
  constructor(private http: HttpClient) { }
  public login(email: string, password: string): Observable<any> {
    return this.http.post(this.loginUrl, {email: email, password: password});
  }

}
