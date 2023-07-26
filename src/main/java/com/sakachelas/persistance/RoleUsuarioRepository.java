package com.sakachelas.persistance;

import com.sakachelas.domain.UserRole;
import com.sakachelas.domain.repository.UserRoleRepository;
import com.sakachelas.persistance.crud.UsuarioRoleCrudRepository;
import com.sakachelas.persistance.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleUsuarioRepository implements UserRoleRepository {

    @Autowired
    private UsuarioRoleCrudRepository usuarioRoleCrudRepository;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void save(UserRole userRole) {
        this.usuarioRoleCrudRepository.save(this.userRoleMapper.toRoleUsuario(userRole));
    }
}
