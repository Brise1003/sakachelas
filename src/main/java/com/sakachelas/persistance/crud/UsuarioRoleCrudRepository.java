package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.RoleUsuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRoleCrudRepository extends CrudRepository<RoleUsuario, String> {
}
