package com.cse544.employeemanagementsystem.employee;

import com.cse544.employeemanagementsystem.auth.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
    @NonNull
    private String title;
    @NonNull
    private Integer salary;
    @NonNull
    private Integer annualLeave;
    private Integer grade;
    private UUID managerId;

    public Employee(@NonNull String username, @NonNull String email, @NonNull String password, boolean enabled, @NonNull String title, @NonNull Integer salary, @NonNull Integer annualLeave, Integer grade, UUID managerId) {
        super(username, email, password, enabled);
        this.title = title;
        this.salary = salary;
        this.annualLeave = annualLeave;
        this.grade = grade;
        this.managerId = managerId;
    }
}
