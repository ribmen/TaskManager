package com.esig.taskmanager.service.impl;

import com.esig.taskmanager.model.entity.Task;
import com.esig.taskmanager.repository.ITaskRepository;
import com.esig.taskmanager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> listTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
