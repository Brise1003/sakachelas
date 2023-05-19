package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

}
