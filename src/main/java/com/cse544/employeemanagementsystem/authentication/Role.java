package com.cse544.employeemanagementsystem.authentication;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    public UUID getId() {
        return id;
    }
}
