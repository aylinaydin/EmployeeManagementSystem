package com.cse544.employeemanagementsystem.employee;

import com.cse544.employeemanagementsystem.auth.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
public class Employee extends User {
    @NonNull
    private String title;
    @NonNull
    private Integer salary;
    @NonNull
    private Integer annualLeave;
    private Integer grade;
    private Integer managerId;

}
