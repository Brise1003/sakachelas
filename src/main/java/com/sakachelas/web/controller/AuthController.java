package com.sakachelas.web.controller;

import com.sakachelas.domain.User;
import com.sakachelas.domain.service.UserService;
import com.sakachelas.persistance.entity.Usuario;
import com.sakachelas.persistance.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    @Operation(description = "Log in session.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    public String login(@RequestBody User user){
        User user1 = userService.verifyEmailPassword(user);

        if(user1 != null){
            return "Ok";
        }else {
            return "fail";
        }

    }

}
