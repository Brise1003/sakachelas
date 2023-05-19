package com.sakachelas.domain.repository;


import com.sakachelas.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUser(int userId);
    User save(User userId);
    void delete(int userId);
}
