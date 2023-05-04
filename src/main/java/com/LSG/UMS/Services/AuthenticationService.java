package com.LSG.UMS.Services;

import com.LSG.UMS.Auth.AuthenticationRequest;
import com.LSG.UMS.Auth.AuthenticationResponse;
import com.LSG.UMS.Auth.RegisterRequest;
import com.LSG.UMS.Models.Role;
import com.LSG.UMS.Models.User;
import com.LSG.UMS.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user.getUsername(), String.valueOf(Role.USER));

        return new AuthenticationResponse(user.getRole().name(), jwtToken, user.getId());
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        System.out.println(user);

        var jwtToken = jwtService.generateToken(user.getUsername(), user.getRole().name());

//        return AuthenticationResponse.builder().token(jwtToken).build();
        return new AuthenticationResponse(user.getRole().name(), jwtToken, user.getId());
    }
}


