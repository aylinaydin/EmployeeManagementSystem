import {Component, OnInit} from '@angular/core';
import {FormControl, ValidationErrors, Validators} from "@angular/forms";
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);
  hide = true

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onClick(): void {
    if (!this.email.value) {
      this.email.markAllAsTouched();
    }
    if (!this.password.value) {
      this.password.markAllAsTouched();
    }

    if (!this.email.valid || !this.password.valid){
      return;
    }

    this.authService.login(this.email.value, this.password.value).subscribe(user => {
      console.log("User:", user);
      if(!user){
      }
      // User nullsa login failed yazdır
      // Burda gelen userı bişr yerde tut
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

  onClickSignUp() {
    this.router.navigateByUrl('/signup');
  }
}
