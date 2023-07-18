package com.sakachelas.persistance;

import com.sakachelas.domain.User;
import com.sakachelas.domain.repository.UserRepository;
import com.sakachelas.persistance.crud.UsuarioCrudRepository;
import com.sakachelas.persistance.entity.Usuario;
import com.sakachelas.persistance.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> userMapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = userMapper.toUsuario(user);
        return userMapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public Optional<User> hasAccount(String email) {
        return Optional.ofNullable(userMapper.toUser(this.usuarioCrudRepository.hasAccount(email)));
    }


}
