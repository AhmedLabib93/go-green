package com.recycling.gogreen.service.impl;

import com.recycling.gogreen.exception.GoGreenAPIException;
import com.recycling.gogreen.model.User;
import com.recycling.gogreen.payload.UserLogin;
import com.recycling.gogreen.payload.request.UserRequest;
import com.recycling.gogreen.repository.UserRepository;
import com.recycling.gogreen.security.JwtTokenProvider;
import com.recycling.gogreen.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(UserLogin userLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLogin.getUsernameOrEmail(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(UserRequest userRegister) {
        if (userRepository.existsByEmail(userRegister.getEmail()))
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "Email already exists!");
        if (userRepository.existsByUsername(userRegister.getUsername()))
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "Email already exists!");

        User user = new User();
        user.setName(userRegister.getName());
        user.setUsername(userRegister.getUsername());
        user.setEmail(userRegister.getEmail());
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        user.setPhone(userRegister.getPhone());
        user.setAddress(userRegister.getAddress());

        userRepository.save(user);

        return "User registered successfully!";
    }
}
