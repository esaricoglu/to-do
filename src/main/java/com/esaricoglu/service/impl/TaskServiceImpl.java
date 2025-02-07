package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoTask;
import com.esaricoglu.dto.DtoTaskIU;
import com.esaricoglu.model.Task;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.TaskRepository;
import com.esaricoglu.service.ITaskService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DtoTask> getAll(User currentUser) {
        List<Task> tasks = taskRepository.findByUserId(currentUser.getId());
        List<DtoTask> dtoTasks = new ArrayList<>();
        for (Task task : tasks) {
            DtoTask dtoTask = modelMapper.map(task, DtoTask.class);
            dtoTasks.add(dtoTask);
        }
        return dtoTasks;
    }

    @Override
    public DtoTask getById(Long id, User currentUser) throws AuthenticationException {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));

        if (!existingTask.getUser().getId().equals(currentUser.getId())) {
            throw new AuthenticationException("You are not allowed to read this task");
        }

        return modelMapper.map(existingTask, DtoTask.class);
    }

    @Override
    public DtoTask save(DtoTaskIU dtoTaskIU, User currentUser) {
        Task task = modelMapper.map(dtoTaskIU, Task.class);
        task.setUser(currentUser);

        taskRepository.save(task);

        return modelMapper.map(task, DtoTask.class);
    }

    @Override
    public String deleteById(Long id, User currentUser) throws AuthenticationException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));

        if (!task.getUser().getId().equals(currentUser.getId())) {
            throw new AuthenticationException("You are not allowed to delete this task");
        }

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }

    @Override
    public DtoTask update(Long id, DtoTaskIU dtoTaskIU, User currentUser) throws AuthenticationException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));

        if (!task.getUser().getId().equals(currentUser.getId())) {
            throw new AuthenticationException("You are not allowed to edit this task");
        }

        modelMapper.map(dtoTaskIU, task);

        taskRepository.save(task);

        return modelMapper.map(task, DtoTask.class);
    }

    @Override
    public DtoTask markAsCompleted(Long id, User currentUser) throws Exception {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));

        if (!task.getUser().getId().equals(currentUser.getId())) {
            throw new AuthenticationException("You are not allowed to edit this task");
        }

        if (task.isCompleted()) {
            throw new Exception("Task is already completed");
        }

        task.setCompleted(true);

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, DtoTask.class);
    }
}
