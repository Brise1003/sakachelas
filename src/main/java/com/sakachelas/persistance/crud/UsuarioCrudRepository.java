package com.sakachelas.persistance.crud;

import com.sakachelas.domain.User;
import com.sakachelas.persistance.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM usuarios WHERE correo = :correo AND password = :password", nativeQuery = true)
    Usuario hasAccount(@Param("correo") String correo,@Param("password") String password);
}
