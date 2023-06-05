package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.request.UserRequest;
import com.recycling.gogreen.payload.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    List<UserResponse> getUsers();

    UserResponse getUserByUsername(String username);

    UserResponse updateUser(long id, UserRequest userRequest);

    void deleteUser(long id);

}
