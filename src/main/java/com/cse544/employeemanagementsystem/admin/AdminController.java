package com.cse544.employeemanagementsystem.admin;

import com.cse544.employeemanagementsystem.Mapper;
import com.cse544.employeemanagementsystem.auth.User;
import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/listEmployees")
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> employee = adminService.getAllEmployee();
        List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
        for (Employee value : employee) {
            EmployeeDto emp = Mapper.employeeToEmployeeDto(value);
            employeeDtoList.add(emp);
        }
        return employeeDtoList;
    }
    @PutMapping("/updateSalaries")
    public boolean updateSalaryForAllEmployees(@RequestBody int increase){
        return adminService.updateSalaryForAllEmployees();
    }



}
