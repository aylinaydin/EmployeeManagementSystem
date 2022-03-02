import { Component, OnInit } from '@angular/core';
import {Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {Employee} from "../interfaces/employee";
import {NewEmployeeForm} from "../interfaces/new-employee-form";
@Component({
  selector: 'app-add-employee-dialog',
  templateUrl: './add-employee-dialog.component.html',
  styleUrls: ['./add-employee-dialog.component.scss']
})
export class AddEmployeeDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<AddEmployeeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: NewEmployeeForm,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
