package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.UserLogin;
import com.recycling.gogreen.payload.request.UserRequest;

public interface AuthService {

    String login(UserLogin userLogin);

    String register(UserRequest userRegister);
}
