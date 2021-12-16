import {Role} from "./role.model";

export interface User {
  uuid: string
  email: string
  password: string
  enabled?: boolean
  roles: Role[]
}
