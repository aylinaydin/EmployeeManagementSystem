package com.cse544.employeemanagementsystem.employee;

import com.cse544.employeemanagementsystem.authentication.User;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User {
    @NonNull
    private String title;
    @NonNull
    private int salary;
    @NonNull
    private int annualLeave;
    private int grade;
    private int managerId;

}
