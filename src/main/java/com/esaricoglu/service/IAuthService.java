package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.LoginRequest;
import com.esaricoglu.jwt.LoginResponse;
import com.esaricoglu.jwt.RegisterRequest;

public interface IAuthService {

    DtoUser register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
