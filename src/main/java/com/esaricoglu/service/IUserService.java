package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;

public interface IUserService {

    DtoUser getUserDetails(User currentUser);

    DtoUser update(DtoUserIU dtoUserIU, User currentUser);

    String delete(User currentUser);
}
