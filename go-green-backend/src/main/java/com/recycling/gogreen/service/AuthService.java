package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.UserLogin;
import com.recycling.gogreen.payload.UserRegister;

public interface AuthService {

    String login(UserLogin userLogin);

    String register(UserRegister userRegister);
}
