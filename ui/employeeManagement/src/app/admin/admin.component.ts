import { Component, OnInit } from '@angular/core';
import {Employee} from "../interfaces/Employee";
import {AdminService} from "../service/admin.service";

const ELEMENT_DATA: Employee[] = [
];
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit{

  displayedColumns: string[] = ['position', 'name', 'surname', 'title', 'salary', 'leaves','grade','manager','actions'];
  dataSource = ELEMENT_DATA;
  private _element: any;
  employeeList: Employee[] = [];

  constructor(private adminService: AdminService){

  }

  ngOnInit(): void {
    this.adminService.getEmployees().subscribe(value => {
      this.employeeList = value;
      console.log(value);
    });
  }

  edit(element: any) {
    this._element = element;
  }



}
