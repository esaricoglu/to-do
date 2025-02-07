package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.RegisterRequest;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IAuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DtoUser register(RegisterRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return modelMapper.map(user, DtoUser.class);
    }
}
