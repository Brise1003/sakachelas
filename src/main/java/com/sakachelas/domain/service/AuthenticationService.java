package com.sakachelas.domain.service;

import com.sakachelas.domain.User;
import com.sakachelas.persistance.UsuarioRepository;
import com.sakachelas.persistance.entity.Role;
import com.sakachelas.web.security.auth.AuthenticationRequest;
import com.sakachelas.web.security.auth.AuthenticationResponse;
import com.sakachelas.web.security.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getFirstname())
                .userLastname(request.getLastname())
                .email(request.getEmail())
                .age(request.getAge())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        usuarioRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        final AuthenticationManager authenticationManager = new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return authentication;
            }
        };

        var user = usuarioRepository.getUserByEmail(request.getEmail()).orElse(null);
        assert user != null;
        System.out.println(user.getEmail()+user.getPassword()+user.getAuthorities());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), user.getAuthorities()));
        var jwtToken = jwtService.generateToken(user);
        System.out.println(jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
