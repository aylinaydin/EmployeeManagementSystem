package com.cse544.employeemanagementsystem.employee;

import com.cse544.employeemanagementsystem.auth.RoleInfo;
import com.cse544.employeemanagementsystem.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class EmployeeDto extends UserDto {
    private String title;
    private Integer salary;
    private Integer annualLeave;
    private Integer grade;
    private Integer managerId;

    public EmployeeDto(UUID id, String username, String email, String password, boolean enabled, RoleInfo role, String title, Integer salary, Integer annualLeave, Integer grade, Integer managerId) {
        super(id, username, email, password, enabled, role);
        this.title = title;
        this.salary = salary;
        this.annualLeave = annualLeave;
        this.grade = grade;
        this.managerId = managerId;
    }
}
