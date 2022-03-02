import {Role} from "../entity/role.model";

export interface Employee {
  username: string;
  email: string;
  password: string,
  enabled: boolean;
  title: string;
  salary: number;
  annualLeave: number;
  grade: number;
  managerId: string;
  role: Role

}
