package com.cse544.employeemanagementsystem.admin;

import com.cse544.employeemanagementsystem.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    public boolean addEmployee(Employee emp){
        return adminService.addEmployee(emp);
    }
    public boolean deleteEmployee(Employee emp){
        return adminService.deleteEmployee(emp);
    }
    public boolean editEmployee(UUID employeeId){
        return adminService.editEmployee(employeeId);
    }
    public boolean updateSalaryForAllEmployees(){
        return adminService.updateSalaryForAllEmployees();
    }
    public boolean updateSalaryForSpecificEmployee(UUID employeeId){
        return adminService.updateSalaryForSpecificEmployee(employeeId);
    }
}
