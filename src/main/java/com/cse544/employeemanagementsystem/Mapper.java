package com.cse544.employeemanagementsystem;

import com.cse544.employeemanagementsystem.auth.RoleInfo;
import com.cse544.employeemanagementsystem.auth.User;
import com.cse544.employeemanagementsystem.auth.UserDto;
import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeDto;

public class Mapper {

    public static UserDto userToUserDto(User user) {
        long roleId = 0;
        String roleName = null;
        if(user.getRole()!=null){
            roleId = user.getRole().getRoleId();
            roleName = user.getRole().getName();
        }
        RoleInfo roleInfo = new RoleInfo(roleId, roleName);
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                roleInfo
        );
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        UserDto userDto = userToUserDto(employee);

        return new EmployeeDto(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.isEnabled(),
                userDto.getRole(),
                employee.getTitle(),
                employee.getSalary(),
                employee.getAnnualLeave(),
                employee.getGrade(),
                employee.getManagerId()
        );
    }
}
