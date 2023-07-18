package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios WHERE correo = :correo", nativeQuery = true)
    Usuario hasAccount(@Param("correo") String email);





}
