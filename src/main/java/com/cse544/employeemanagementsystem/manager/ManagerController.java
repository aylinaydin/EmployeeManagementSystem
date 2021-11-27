package com.cse544.employeemanagementsystem.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    public boolean setGradeForEmployee(UUID employeeId, int grade){
        return managerService.setGradeForEmployee(employeeId,grade);
    }
    public List getAllSubordinateEmployees(){
        return managerService.getAllSubordinateEmployees();
    }
}
