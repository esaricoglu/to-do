package com.esaricoglu.service;

import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoTask;
import com.esaricoglu.dto.DtoTaskIU;
import com.esaricoglu.model.User;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ITaskService {

    List<DtoTask> getAll(User currentUser);

    DtoTask getById(Long id, User currentUser) throws AuthenticationException;

    DtoTask save(DtoTaskIU dtoTaskIU, User currentUser);

    String deleteById(Long id, User currentUser) throws AuthenticationException;

    DtoTask update(Long id, DtoTaskIU dtoTaskIU, User currentUser) throws AuthenticationException;

    DtoTask markAsCompleted(Long id, User currentUser) throws Exception;

}
