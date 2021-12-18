import {Role} from "./role.model";

export interface User {
  id: string
  email: string
  password: string
  enabled?: boolean
  role: Role
}
