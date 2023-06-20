package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.UserRegister;
import com.recycling.gogreen.payload.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();

    UserResponse getUserByUsernameOrEmail(String usernameOrEmail);

    UserResponse updateUser(long id, UserRegister userRequest);

    void deleteUser(long id);

}
