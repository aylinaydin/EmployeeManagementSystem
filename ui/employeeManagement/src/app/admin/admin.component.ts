import {Component, OnInit} from '@angular/core';
import {Employee} from "../interfaces/employee";
import {AdminService} from "../service/admin.service";
import {MatDialog} from '@angular/material/dialog';
import {AddEmployeeDialogComponent} from "../add-employee-dialog/add-employee-dialog.component";
import {NewEmployeeForm} from "../interfaces/new-employee-form";
import {Role} from "../entity/role.model";
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  displayedColumns: string[] = ['username', 'title', 'salary', 'leaves', 'grade', 'manager', 'actions'];
  private _element: any;
  employeeList: Employee[] = [];

  constructor(private adminService: AdminService, public dialog: MatDialog, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.getEmployeeList();
  }

  edit(element: Employee) {
    console.log(element)
    this._element = element;

    const isManager = element.role.roleId === 19;

    const dialogRef = this.dialog.open(AddEmployeeDialogComponent, {
      disableClose: true,
      width: '30%',
      data: {
        username: element.username,
        email: element.email,
        password: element.password,
        enabled: element.enabled,
        title: element.title,
        salary: element.salary,
        annualLeave: element.annualLeave,
        grade: element.grade,
        managerId: element.managerId,
        isManager: isManager
      }
    });
    dialogRef.afterClosed().subscribe((result: NewEmployeeForm) => {
      if (!result) return

      console.log('The dialog was closed');
      //console.log(result)
      let role: Role;
      if(result.isManager) {
        role = {
          name: 'manager',
          roleId: 19
        }
      } else {
        role = {
          name: 'employee',
          roleId: 18
        }
      }
      const employee: Employee = {
        email: result.email,
        role: role,
        password: result.password,
        annualLeave: result.annualLeave,
        enabled: result.enabled,
        grade: result.grade,
        managerId: result.managerId,
        salary: result.salary,
        title: result.title,
        username: result.username
      }
      this.adminService.editEmployee(employee).subscribe(value => {
        console.log(value);
        this.employeeList = []
        this.getEmployeeList();
      });
    });

  }


  openDialog() {
    //  TODO: 1. dialog için yeni bir component oluştur ng g c add-employee-dialog
    //  2. matDialog inject et constructorda
    //  3. mat dialog ve oluşturduğun componenti kullanarak buton tıklamasında o dialogu göster
    //  4. dialog componentinde employee formunu oluşturup o datayı burada kullanıyor olman lzım
    const dialogRef = this.dialog.open(AddEmployeeDialogComponent, {
      disableClose: true,
      width: '30%',
      data: {}
    });

    dialogRef.afterClosed().subscribe((result: NewEmployeeForm) => {
      if (!result) return

      console.log('The dialog was closed');
      //console.log(result)
      let role: Role;
      if(result.isManager) {
        role = {
          name: 'manager',
          roleId: 19
        }
      } else {
        role = {
          name: 'employee',
          roleId: 18
        }
      }
      const employee: Employee = {
        email: result.email,
        role: role,
        password: result.password,
        annualLeave: result.annualLeave,
        enabled: result.enabled,
        grade: result.grade,
        managerId: result.managerId,
        salary: result.salary,
        title: result.title,
        username: result.username
      }
      this.adminService.addEmployee(employee).subscribe(value => {
        console.log(value);
        this.getEmployeeList();
      });
    });
  }

  private getEmployeeList() {
    this.adminService.getEmployees().subscribe(value => {
      this.employeeList = value;
    });
  }

  onLogoutClick() {
    this.authService.logout();
    console.log("logout");
  }
}
