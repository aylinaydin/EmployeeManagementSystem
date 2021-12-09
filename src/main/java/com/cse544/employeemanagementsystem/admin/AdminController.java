package com.cse544.employeemanagementsystem.admin;

import com.cse544.employeemanagementsystem.auth.User;
import com.cse544.employeemanagementsystem.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return adminService.addEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id){
         adminService.deleteEmployee(id);
    }
    @PutMapping()
    public Employee editEmployee(@RequestBody Employee employee){
        return adminService.editEmployee(employee);
    }
    public boolean updateSalaryForAllEmployees(){
        return adminService.updateSalaryForAllEmployees();
    }
    public boolean updateSalaryForSpecificEmployee(UUID employeeId){
        return adminService.updateSalaryForSpecificEmployee(employeeId);
    }
}
