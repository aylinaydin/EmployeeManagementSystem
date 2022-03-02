import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Employee} from "../interfaces/employee";

@Injectable({
  providedIn: 'root'
})


export class AdminService {

  private authUrl: string = 'http://localhost:8080/admin'

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.authUrl + '/listEmployees')
  }
  addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.authUrl + '/employee',employee);
  }
  editEmployee(employee: Employee): Observable<Employee>{
    return this.http.put<Employee>(this.authUrl+ '/editEmployee', employee);
  }

  constructor(private http: HttpClient, private router: Router) {
  }
}
