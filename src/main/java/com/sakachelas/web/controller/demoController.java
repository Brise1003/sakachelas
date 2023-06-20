package com.sakachelas.web.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-controller")
public class demoController {

    @GetMapping("/dummy")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured endpoint.");
    }
}
