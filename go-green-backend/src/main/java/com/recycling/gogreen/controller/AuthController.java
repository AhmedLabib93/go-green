package com.recycling.gogreen.controller;

import com.recycling.gogreen.exception.GoGreenAPIException;
import com.recycling.gogreen.payload.request.UserRequest;
import com.recycling.gogreen.payload.response.UserResponse;
import com.recycling.gogreen.repository.UserRepository;
import com.recycling.gogreen.security.JwtTokenProvider;
import com.recycling.gogreen.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/gogreen/v1/auth/")
public class AuthController {


}
