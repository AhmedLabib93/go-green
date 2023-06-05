package com.recycling.gogreen.service;

import com.recycling.gogreen.model.User;
import com.recycling.gogreen.model.request.UserRequest;
import com.recycling.gogreen.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    List<UserResponse> getUsers();

    UserResponse findByUsername(String username);

    UserResponse updateUser(long id, UserRequest userRequest);

    void deleteUser(long id);

}
