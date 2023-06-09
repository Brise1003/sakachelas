package com.sakachelas.web.controller;

import com.sakachelas.domain.User;
import com.sakachelas.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @Operation(description = "Get account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Beer not found")
    })
    public ResponseEntity<User> getUser(@Parameter @PathVariable("id") int userId){
        return userService.getUser(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete a user by id from catalog.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity deleteUser(@Parameter @PathVariable("id") int userId){
        return userService.delete(userId) ?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
