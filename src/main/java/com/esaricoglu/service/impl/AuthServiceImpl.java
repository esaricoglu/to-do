package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.JwtService;
import com.esaricoglu.jwt.LoginRequest;
import com.esaricoglu.jwt.LoginResponse;
import com.esaricoglu.jwt.RegisterRequest;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IAuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Override
    public DtoUser register(RegisterRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return modelMapper.map(user, DtoUser.class);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> user = userRepository.findByUsername(request.getUsername());
            String token = jwtService.generateToken(user.get());

            return new LoginResponse(token);
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
        return null;
    }
}
