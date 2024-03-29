package com.sakachelas.domain.repository;


import com.sakachelas.domain.User;
import com.sakachelas.persistance.entity.Usuario;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUser(int userId);
    Optional<User> getUserByEmail(String email);
    void save(User user);
    void delete(int userId);
    Optional<User> hasAccount(String email);

}
