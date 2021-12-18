import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {User} from "../entity/user.model";
import {map, Observable} from "rxjs";
import {Employee} from "../entity/employee.model";
import {Router} from "@angular/router";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authUrl: string = 'http://localhost:8080/auth'

  public user: User | null = null;

  constructor(private http: HttpClient, private router: Router) { }

  login(email: string, password: string): Observable<User> {
    let params = new HttpParams();
    params = params.append('email', email);
    params = params.append('password', password);

    return this.http.get<User>(this.authUrl + '/login', { params: params }).pipe(map(user => {
      // localStorage.setItem('user', JSON.stringify(user));
      this.user = user;
      return user;
    }));
  }

  logout() {
    this.user = null;
    this.router.navigate(['login']);
  }

  signup(email: string, password: string): Observable<Employee> {
    let params = new HttpParams();
    params = params.append('email', email);
    params = params.append('password', password);

    return this.http.put<Employee>(this.authUrl + '/signup',{}, { params: params});
  }
}
