export interface NewEmployeeForm {
  username: string;
  email: string;
  password: string,
  enabled: boolean;
  title: string;
  salary: number;
  annualLeave: number;
  grade: number;
  managerId: string;
  isManager: boolean
}
