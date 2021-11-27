package com.cse544.employeemanagementsystem;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
public class User {
    @Id @NonNull
    private UUID id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;

    public boolean login(String email, String psswd){
        return true;
    }


}
