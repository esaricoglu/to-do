package com.esaricoglu.controller.impl;

import com.esaricoglu.controller.IUserController;
import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;
import com.esaricoglu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/users")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @Override
    @GetMapping
    public RootEntity<DtoUser> getUserDetails(User currentUser) {
        return RootEntity.ok(userService.getUserDetails(currentUser));
    }

    @Override
    @PostMapping("/update")
    public RootEntity<DtoUser> update(DtoUserIU dtoUserIU, User currentUser) {
        return RootEntity.ok(userService.update(dtoUserIU, currentUser));
    }

    @Override
    @DeleteMapping("/delete")
    public RootEntity<String> delete(User currentUser) {
        return RootEntity.ok(userService.delete(currentUser));
    }
}
