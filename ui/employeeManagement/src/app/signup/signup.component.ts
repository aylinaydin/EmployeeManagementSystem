import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {AuthService} from "../service/auth.service";
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);
  hide = true

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onClick() {
    if (!this.email.value) {
      this.email.markAllAsTouched();
    }
    if (!this.password.value) {
      this.password.markAllAsTouched();
    }

    if (!this.email.valid || !this.password.valid){
      return;
    }
    this.authService.signup(this.email.value,this.password.value).subscribe(employee =>{
      if(!employee){
        console.log("Cannot signup this user");
      }

    })

  }
  getEmailErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  getPwdErrorMessage() {
    if (this.password.hasError('required')) {
      return 'You must enter a value';
    }
    return '';
  }


}
