import {Component, OnInit} from '@angular/core';
import {AuthService} from "../service/auth.service";
import {Employee} from "../entity/employee.model";
import {User} from "../entity/user.model";
import {EmployeeService} from "../service/employee.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  employee: Employee | undefined;
  user: User | null | undefined;

  constructor(private authService: AuthService, private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.user = this.authService.user;
    if(this.user){
      this.employeeService.getEmployee(this.user.id).subscribe(value => {
        this.employee=value;
      });
    }
  }

  onLogoutClick() {
    this.authService.logout();
    console.log("logout");
  }
}
