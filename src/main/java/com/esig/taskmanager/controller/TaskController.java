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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@Component(value = "taskMB")
@ViewScoped
@Slf4j
public class TaskController implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Inject
    public TaskController(ITaskService taskService){
        this.taskService = taskService;
    }

    private final ITaskService taskService;

    @Getter
    @Setter
    private Task task = new Task(); // Objeto para cadastro

    @Getter
    private List<Task> taskList;

    @Getter
    @Setter
    private Integer searchId;

    @Getter
    @Setter
    private String searchTitle;

    @Getter
    @Setter
    private String searchAssignee;

    @Getter
    @Setter
    private Boolean searchPending; // true = pendente, false = concluída

    @Getter
    private List<Task> searchResults;


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

    public void loadTasks() {
        taskList = taskService.listTasks();
    }

    public void save() {
        try {
            log.info("Salvando nova tarefa: " + task);
            taskService.saveTask(task);
            task = new Task();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa adicionada com sucesso!"));
            loadTasks();
        } catch (Exception e) {
            log.error("Erro ao salvar tarefa", e);
        }
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
            log.info("Deletar tarefa");
            taskService.deleteTask(task);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa excluída com sucesso."));
            loadTasks();
        } catch (Exception e) {
            log.error("Erro ao deletar tarefa", e);
        }

    }

    // parte da busca

    public void searchTasks() {
        log.info("Realizando busca com filtros - Título: '{}', Responsável: '{}', Situação: {}",
                searchTitle, searchAssignee, searchPending);
        searchResults = taskService.findTaskByFilters(searchTitle, searchAssignee , searchPending);
        log.info("Tarefas encontradas: {}", searchResults.size());

        if (searchResults.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Nenhuma tarefa encontrada."));
        }
    }



}
