package com.sakachelas.web.security.auth;

import com.sakachelas.persistance.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
    private Role role;
}
