package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.RegisterRequest;

public interface IAuthService {

    DtoUser register(RegisterRequest request);
}
