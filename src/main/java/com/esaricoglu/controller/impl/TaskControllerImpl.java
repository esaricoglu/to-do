package com.esaricoglu.controller.impl;

import com.esaricoglu.controller.ITaskController;
import com.esaricoglu.core.RootEntity;
import com.esaricoglu.dto.DtoTask;
import com.esaricoglu.dto.DtoTaskIU;
import com.esaricoglu.model.User;
import com.esaricoglu.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController("/api/tasks")
public class TaskControllerImpl implements ITaskController {

    @Autowired
    private ITaskService taskService;

    @Override
    @GetMapping
    public RootEntity<List<DtoTask>> getAll(@AuthenticationPrincipal User currentUser) {
        return RootEntity.ok(taskService.getAll(currentUser));
    }

    @Override
    @GetMapping("/{id}")
    public RootEntity<DtoTask> getById(@PathVariable Long id, @AuthenticationPrincipal User currentUser) throws AuthenticationException {
        return RootEntity.ok(taskService.getById(id, currentUser));
    }

    @Override
    @PostMapping("/save")
    public RootEntity<DtoTask> save(@RequestBody DtoTaskIU dtoTaskIU, @AuthenticationPrincipal User currentUser) {
        return RootEntity.ok(taskService.save(dtoTaskIU, currentUser));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RootEntity<String> deleteById(@PathVariable Long id, @AuthenticationPrincipal User currentUser) throws AuthenticationException {
        return RootEntity.ok(taskService.deleteById(id, currentUser));
    }

    @Override
    @PutMapping("/update/{id}")
    public RootEntity<DtoTask> update(@PathVariable Long id, @RequestBody DtoTaskIU dtoTaskIU, @AuthenticationPrincipal User currentUser) throws AuthenticationException {
        return RootEntity.ok(taskService.update(id, dtoTaskIU, currentUser));
    }

    @Override
    @PutMapping("/complete/{id}")
    public RootEntity<DtoTask> markAsCompleted(@PathVariable Long id, @AuthenticationPrincipal User currentUser) throws Exception {
        return RootEntity.ok(taskService.markAsCompleted(id, currentUser));
    }
}
