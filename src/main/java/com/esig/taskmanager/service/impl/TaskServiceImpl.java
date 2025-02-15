package com.esig.taskmanager.service.impl;

import com.esig.taskmanager.model.entity.Task;
import com.esig.taskmanager.repository.ITaskRepository;
import com.esig.taskmanager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public Task updateTask(Integer id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setAssignee(updatedTask.getAssignee());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setDate(updatedTask.getDate());

            return taskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public List<Task> findTaskByFilters(Integer id, String title, String assignee, Boolean pending) {
        return taskRepository.findByFilters(id, title, assignee, pending);
    }
}
