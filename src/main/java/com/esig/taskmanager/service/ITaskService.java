package com.esig.taskmanager.service;

import com.esig.taskmanager.model.entity.Task;

import java.util.List;

public interface ITaskService {

    public Task saveTask(Task task);
    public Task findTaskById(Integer id);
    public List<Task> listTasks();
    public Task updateTask(Integer id, Task task);
    public void deleteTask(Task task);

}
