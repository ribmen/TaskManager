package com.esig.taskmanager.controller;

import com.esig.taskmanager.model.entity.Assignees;
import com.esig.taskmanager.model.entity.Task;
import com.esig.taskmanager.model.entity.TaskPriority;
import com.esig.taskmanager.service.ITaskService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@Component(value = "taskMB")
@ViewScoped
public class TaskController implements Serializable {

    @Inject
    private ITaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Getter
    @Setter
    private Task task = new Task(); // Objeto para cadastro

    @Getter
    private List<Task> taskList;

    public List<TaskPriority> getPriorities() {
        return Arrays.asList(TaskPriority.listPriorities());
    }

    public List<Assignees> getAssignees() {
        return Arrays.asList(Assignees.listAssignees());
    }

    public void setSelectedTask(Task task) {
        this.task = task;
    }

    public void concludeTask(Task task) {
        task.setPending(false);
        taskService.saveTask(task);
    }

    @PostConstruct
    public void init() {
        task = new Task();
        loadTasks();
    }

    public void save() {
        try {
            logger.info("Salvando nova tarefa: " + task);
            taskService.saveTask(task);
            task = new Task();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa adicionada com sucesso!"));
            loadTasks();
            logger.info("Tarefa salva com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao salvar tarefa", e);
        }
    }

    public void loadTasks() {
        taskList = taskService.listTasks();
    }

    public void edit() {
        if (task.getId() != null ) {
            taskService.updateTask(task.getId(), task);
            loadTasks();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso","Tarefa editada com sucesso!"));
        }
    }

    public void delete(Task task) {
        try {
            logger.info("Deletar tarefa");
            taskService.deleteTask(task);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa excluída com sucesso."));
            loadTasks();
        } catch (Exception e) {
            logger.error("Erro ao deletar tarefa", e);
        }

    }
}
