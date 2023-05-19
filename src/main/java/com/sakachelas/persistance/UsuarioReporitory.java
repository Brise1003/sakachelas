package com.sakachelas.persistance;

import com.sakachelas.domain.User;
import com.sakachelas.domain.repository.UserRepository;
import com.sakachelas.persistance.crud.UsuarioCrudRepository;
import com.sakachelas.persistance.entity.Usuario;
import com.sakachelas.persistance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioReporitory implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> userMapper.toUser(usuario));
    }

    @Override
    public User save(User userId) {
        Usuario usuario = userMapper.toUsuario(userId);
        return userMapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }
}
