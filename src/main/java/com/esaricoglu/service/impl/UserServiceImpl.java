package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DtoUser getUserDetails(User currentUser) {
        return modelMapper.map(currentUser, DtoUser.class);
    }

    @Override
    public DtoUser update(DtoUserIU dtoUserIU, User currentUser) {
        User updatedUser = modelMapper.map(dtoUserIU, User.class);
        updatedUser.setId(currentUser.getId());
        userRepository.save(updatedUser);

        return modelMapper.map(updatedUser, DtoUser.class);
    }

    @Override
    public String delete(User currentUser) {
        userRepository.deleteById(currentUser.getId());
        return "User deleted successfully";
    }
}
