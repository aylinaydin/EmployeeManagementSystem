package com.cse544.employeemanagementsystem.admin;

import com.cse544.employeemanagementsystem.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {


    public boolean addEmployee(Employee emp){
        //logic
        return true;
    }
    public boolean deleteEmployee(Employee emp){
        //logic
        return true;
    }
    public boolean editEmployee(UUID employeeId){
        //logic
        return true;
    }
    public boolean updateSalaryForAllEmployees(){
        //logic
        return true;
    }
    public boolean updateSalaryForSpecificEmployee(UUID employeeId){
        //logic
        return true;
    }

}
