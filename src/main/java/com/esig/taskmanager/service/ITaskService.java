package com.esig.taskmanager.service;

import com.esig.taskmanager.model.entity.Task;

import java.util.List;

public interface ITaskService {

    public Task saveTask(Task task);
    public Task findTaskById(Integer id);
    public List<Task> listTasks();
    public void deleteTask(Task task);

}
