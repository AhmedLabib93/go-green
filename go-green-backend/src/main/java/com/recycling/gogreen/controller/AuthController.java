package com.recycling.gogreen.controller;

import com.recycling.gogreen.payload.UserLogin;
import com.recycling.gogreen.payload.UserRegister;
import com.recycling.gogreen.payload.response.JwtAuthResponse;
import com.recycling.gogreen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/gogreen/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody UserLogin userLogin) {
        String token = authService.login(userLogin);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegister userRegister) {
        String response = authService.register(userRegister);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

}
