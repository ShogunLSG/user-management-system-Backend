package com.LSG.UMS.Controllers;

import com.LSG.UMS.Auth.AuthenticationRequest;
import com.LSG.UMS.Auth.AuthenticationResponse;
import com.LSG.UMS.Auth.RegisterRequest;
import com.LSG.UMS.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterRequest request
    ){
//        return authenticationService.register(request);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
<<<<<<< HEAD
    public ResponseEntity authenticate(
            @RequestBody AuthenticationRequest request){
=======
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
>>>>>>> 4fdf0db7de395f2620f0bd679ddca0182ad0f555

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
