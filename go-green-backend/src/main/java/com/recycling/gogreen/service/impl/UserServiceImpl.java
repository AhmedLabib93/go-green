package com.recycling.gogreen.service.impl;

import com.recycling.gogreen.exception.ResourceNotFound;
import com.recycling.gogreen.model.User;
import com.recycling.gogreen.payload.UserRegister;
import com.recycling.gogreen.payload.response.UserResponse;
import com.recycling.gogreen.repository.UserRepository;
import com.recycling.gogreen.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user)
                -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByUsernameOrEmail(String usernameOrEmail) {
        User user = userRepository.findUserByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(()
                -> new ResourceNotFound(String.format("User with username/email %s not found", usernameOrEmail)));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(long id, UserRegister userRequest) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound(String.format("User with id %d not found", id)));
        //user.setId(id);
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        //user.setPassword(userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        user.setName(userRequest.getName());
        user.setPhone(userRequest.getPhone());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound(String.format("User with id %d not found", id)));
        userRepository.delete(user);
    }
}
