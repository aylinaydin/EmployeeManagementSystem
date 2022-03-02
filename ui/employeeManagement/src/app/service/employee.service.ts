import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Employee} from "../entity/employee.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


  private employeeUrl: string = 'http://localhost:8080/employee'

  constructor(private http: HttpClient) { }

  getEmployee(id: string): Observable<Employee> {
    return this.http.get<Employee>(this.employeeUrl + '/'+ id);
  }
}
