package com.cse544.employeemanagementsystem.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleInfo {
    private long roleId;
    private String name;
}
