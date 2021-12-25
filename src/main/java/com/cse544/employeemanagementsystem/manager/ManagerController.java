package com.cse544.employeemanagementsystem.manager;

import com.cse544.employeemanagementsystem.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("/listEmployees")
    public List<EmployeeDto> getAllSubordinateEmployees(@RequestBody UUID managerId){
        return managerService.getAllSubordinateEmployees(managerId);
    }
    @PutMapping("/setGrade")
    public void setGradeForEmployee(@RequestBody UUID employeeId, @RequestBody int grade){
        managerService.setGradeForEmployee(employeeId,grade);
    }
}
