package com.sakachelas.domain.service;

import com.sakachelas.domain.User;
import com.sakachelas.domain.repository.UserRepository;
import com.sakachelas.persistance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }

    public Optional<User> getUserByemail(String email){
        return userRepository.getUserByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public boolean delete(int userId){
        return getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }

}
