package com.esig.taskmanager.service.impl;

import com.esig.taskmanager.model.entity.Assignees;
import com.esig.taskmanager.model.entity.Task;
import com.esig.taskmanager.repository.ITaskRepository;
import com.esig.taskmanager.repository.TaskRepositoryQuery;
import com.esig.taskmanager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    public TaskServiceImpl(ITaskRepository taskRepository, TaskRepositoryQuery taskRepositoryQuery) {
        this.taskRepository = taskRepository;
        this.taskRepositoryQuery = taskRepositoryQuery;
    }

    private final ITaskRepository taskRepository;


    private final TaskRepositoryQuery taskRepositoryQuery;

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
    public List<Task> findTaskByFilters(String title, Assignees assignee, Boolean pending) {
        return taskRepositoryQuery.queryByFields(title, assignee, pending);
    }
}
