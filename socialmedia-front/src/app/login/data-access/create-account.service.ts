import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {
  private createAccountUrl: string = "http://localhost:8080/users"
  constructor(private http: HttpClient) { }

  public createAccount(email: string, password: string, name: string): Observable<any> {
    return this.http.post(this.createAccountUrl, {email: email, password: password, name: name});
  }

}
