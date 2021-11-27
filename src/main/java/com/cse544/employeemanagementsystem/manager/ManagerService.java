package com.cse544.employeemanagementsystem.manager;

import com.cse544.employeemanagementsystem.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManagerService {

    public boolean setGradeForEmployee(UUID employeeId, int grade){
        //logic
        return true;
    }
    public List getAllSubordinateEmployees(){
        List emp = null;
        //logic
        return emp;
    }
}
