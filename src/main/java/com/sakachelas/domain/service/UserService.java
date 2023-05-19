package com.sakachelas.domain.service;

import com.sakachelas.domain.User;
import com.sakachelas.domain.repository.UserRepository;
import com.sakachelas.persistance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(int userId){
        return getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
