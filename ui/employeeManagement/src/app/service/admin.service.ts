import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Employee} from "../interfaces/Employee";

@Injectable({
  providedIn: 'root'
})


export class AdminService {

  private authUrl: string = 'http://localhost:8080/admin'

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.authUrl + '/listEmployees')
  }

  constructor(private http: HttpClient, private router: Router) {
  }
}
