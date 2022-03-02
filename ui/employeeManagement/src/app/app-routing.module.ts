import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin/admin.component";
import {SignupComponent} from "./signup/signup.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./auth.guard";
import {ManagerComponent} from "./manager/manager.component";
import {EmployeeComponent} from "./employee/employee.component";

const routes: Routes = [
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
  {path: 'manager', component: ManagerComponent, canActivate: [AuthGuard]},
  {path: 'employee', component: EmployeeComponent, canActivate: [AuthGuard]},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', component: LoginComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
