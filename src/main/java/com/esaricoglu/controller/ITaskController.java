package com.esaricoglu.controller;

import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoTask;
import com.esaricoglu.dto.DtoTaskIU;
import com.esaricoglu.model.User;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ITaskController {

    RootEntity<List<DtoTask>> getAll(User currentUser);

    RootEntity<DtoTask> getById(Long id, User currentUser) throws AuthenticationException;

    RootEntity<DtoTask> save(DtoTaskIU dtoTaskIU, User currentUser);

    RootEntity<String> deleteById(Long id, User currentUser) throws AuthenticationException;

    RootEntity<DtoTask> update(Long id, DtoTaskIU dtoTaskIU, User currentUser) throws AuthenticationException;

    RootEntity<DtoTask> markAsCompleted(Long id, User currentUser) throws Exception;
}
