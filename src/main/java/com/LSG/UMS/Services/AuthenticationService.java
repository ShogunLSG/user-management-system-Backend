package com.LSG.UMS.Services;

import com.LSG.UMS.Auth.AuthenticationRequest;
import com.LSG.UMS.Auth.AuthenticationResponse;
import com.LSG.UMS.Auth.RegisterRequest;
import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request) {
        if(userRepository.findUserByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already exists");
        }

        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user.getEmail(), String.valueOf(Role.USER));

        return ResponseEntity.ok(new AuthenticationResponse(user.getRole().name(), jwtToken, user.getId()));
    }

    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        System.out.println(user);

        var jwtToken = jwtService.generateToken(user.getUsername(), user.getRole().name());


        return ResponseEntity.ok(new AuthenticationResponse(user.getRole().name(), jwtToken, user.getId()));
    }
}


