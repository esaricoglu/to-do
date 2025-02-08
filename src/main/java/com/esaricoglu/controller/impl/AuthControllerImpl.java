package com.esaricoglu.controller.impl;

import com.esaricoglu.controller.IAuthController;
import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.LoginRequest;
import com.esaricoglu.jwt.LoginResponse;
import com.esaricoglu.jwt.RegisterRequest;
import com.esaricoglu.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private IAuthService authService;

    @Override
    @PostMapping("/register")
    public RootEntity<DtoUser> register(@RequestBody @Valid RegisterRequest request) {
        return RootEntity.ok(authService.register(request));
    }

    @Override
    @PostMapping("/login")
    public RootEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return RootEntity.ok(authService.login(request));
    }
}
