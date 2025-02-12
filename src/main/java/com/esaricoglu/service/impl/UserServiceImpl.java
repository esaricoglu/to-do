package com.esaricoglu.service.impl;

import com.esaricoglu.core.mapper.IModelMapper;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public DtoUser getUserDetails(User currentUser) {
        return modelMapper.forResponse().map(currentUser, DtoUser.class);
    }

    @Override
    public DtoUser update(DtoUserIU dtoUserIU, User currentUser) {
        dtoUserIU.setPassword(passwordEncoder.encode(dtoUserIU.getPassword()));
        User updatedUser = modelMapper.forRequest().map(dtoUserIU, User.class);
        updatedUser.setId(currentUser.getId());
        userRepository.save(updatedUser);

        return modelMapper.forResponse().map(updatedUser, DtoUser.class);
    }

    @Override
    public String delete(User currentUser) {
        userRepository.deleteById(currentUser.getId());
        return "User deleted successfully";
    }
}
