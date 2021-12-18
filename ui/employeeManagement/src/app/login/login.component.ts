import {Component, OnInit} from '@angular/core';
import {FormControl, ValidationErrors, Validators} from "@angular/forms";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {first} from "rxjs";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);
  hide = true

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute) {
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

    if (!this.email.valid || !this.password.valid) {
      return;
    }

    this.authService.login(this.email.value, this.password.value)
      .pipe(first())
      .subscribe({
        next: (user) => {
          let returnUrl = ''
          if (user.role.name === 'admin') {
            returnUrl = '/admin';
          } else if (user.role.name === 'employee') {
            returnUrl = '/employee';
          } else if (user.role.name === 'manager') {
            returnUrl = '/manager';
          }

          this.router.navigate([returnUrl]);
        },
        error: () => {
          console.log('Error!')
        }
      });
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
