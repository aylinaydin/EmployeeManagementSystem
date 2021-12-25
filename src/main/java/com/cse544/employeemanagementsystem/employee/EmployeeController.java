package com.cse544.employeemanagementsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeInfo(@PathVariable  UUID id){
        return empService.getEmployeeInfo(id);
    }
    @PutMapping("/enterLeaves")
    public Boolean enterLeaves(@RequestBody int leaveNum, @RequestBody UUID id ){
        return empService.enterLeaves(leaveNum,id);
    }
}
