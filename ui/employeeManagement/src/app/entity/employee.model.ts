import {User} from "./user.model";
export interface Employee extends User{
  title: string
  salary: number
  annualLeave: number
  grade: number
  managerId: number
}
