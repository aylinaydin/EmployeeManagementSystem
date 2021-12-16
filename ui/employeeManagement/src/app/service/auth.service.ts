import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {User} from "../entity/user.model";
import {Observable} from "rxjs";
import {Employee} from "../entity/employee.model";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl: string = 'http://localhost:8080/auth'

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<User> {
    let params = new HttpParams();
    params = params.append('email', email);
    params = params.append('password', password);

    return this.http.get<User>(this.authUrl + '/login', { params: params });
  }
  signup(email: string, password: string): Observable<Employee> {
    let params = new HttpParams();
    params = params.append('email', email);
    params = params.append('password', password);

    return this.http.get<Employee>(this.authUrl + '/signup', { params: params});
  }

}
