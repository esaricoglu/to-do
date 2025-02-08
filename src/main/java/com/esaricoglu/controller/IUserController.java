package com.esaricoglu.controller;

import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;

public interface IUserController {

    RootEntity<DtoUser> getUserDetails(User currentUser);

    RootEntity<DtoUser> update(DtoUserIU dtoUserIU, User currentUser);

    RootEntity<String> delete(User currentUser);
}
