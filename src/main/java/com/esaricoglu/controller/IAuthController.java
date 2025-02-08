package com.esaricoglu.controller;

import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.LoginRequest;
import com.esaricoglu.jwt.LoginResponse;
import com.esaricoglu.jwt.RegisterRequest;

public interface IAuthController {

    RootEntity<DtoUser> register(RegisterRequest request);

    RootEntity<LoginResponse> login(LoginRequest request);
}
