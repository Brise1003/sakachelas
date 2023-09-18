package com.sakachelas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnviarCorreo {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/enviarcorreo")
    public ResponseEntity<?> enviar_correo(){
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo("paudelg@yahoo.com.mx");
        email.setFrom("samuelbrise@hotmail.com");
        email.setSubject("Sakachelas Confirmación de pedido");
        email.setText("No responder, esta es una prueba.");

        mailSender.send(email);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
