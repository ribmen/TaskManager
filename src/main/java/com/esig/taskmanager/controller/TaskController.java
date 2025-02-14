package com.esig.taskmanager.controller;

import com.esig.taskmanager.model.entity.Task;
import com.esig.taskmanager.service.ITaskService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Named
@Component(value = "taskMB")
@ViewScoped
public class TaskController implements Serializable {

    @Inject
    private ITaskService taskService;

    @Getter
    @Setter
    private Task task = new Task(); // Objeto para cadastro

    @Getter
    private List<Task> taskList; // Lista de tarefas

    public void save() {
        taskService.saveTask(task);
        task = new Task(); // Reseta o formulário
        loadTasks(); // Atualiza a lista na view
    }

    @PostConstruct
    public void init() {
        loadTasks();
    }
    public void loadTasks() {
        taskList = taskService.listTasks();
    }

    public void delete(Task task) {
        taskService.deleteTask(task);
        loadTasks();
    }
}
