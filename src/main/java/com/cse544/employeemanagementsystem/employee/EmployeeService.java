package com.cse544.employeemanagementsystem.employee;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class EmployeeService {

    public Employee getEmployeeInfo(UUID employeeID){
        //logic
        Employee emp = new Employee();
        return emp;
    }
    public void enterLeaves(Date from, Date to){
        //logic
    }

}
