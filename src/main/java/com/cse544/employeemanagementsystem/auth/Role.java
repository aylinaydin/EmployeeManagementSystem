package com.cse544.employeemanagementsystem.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USER = "USER";
    public static final String EMPLOYEE = "employee";
    public static final String ADMIN = "ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(name, ((Role) obj).getName());
    }

    @Override
    public String toString() {
        return "Role [name=" + name + "]" + "[id=" + roleId + "]";
    }


}
