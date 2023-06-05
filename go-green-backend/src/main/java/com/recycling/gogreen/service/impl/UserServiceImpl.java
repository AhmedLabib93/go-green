package com.recycling.gogreen.service.impl;

import com.recycling.gogreen.exception.ResourceNotFound;
import com.recycling.gogreen.model.User;
import com.recycling.gogreen.model.request.UserRequest;
import com.recycling.gogreen.model.response.UserResponse;
import com.recycling.gogreen.repository.UserRepository;
import com.recycling.gogreen.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map((user)
                -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()
                -> new ResourceNotFound(String.format("User with username %s not found", username)));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(long id, UserRequest userRequest) {
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
