package com.sakachelas.domain.service;

import com.sakachelas.domain.UserRole;
import com.sakachelas.persistance.RoleUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private RoleUsuarioRepository roleUsuarioRepository;

    public void saveUserRole(UserRole userRole){
        this.roleUsuarioRepository.save(userRole);
    }
}
