package com.cse544.employeemanagementsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    public Employee getEmployeeInfo(UUID employeeID){
        return empService.getEmployeeInfo(employeeID);
    }
    public void enterLeaves(Date from, Date to){
        empService.enterLeaves(from,to);
    }
}
