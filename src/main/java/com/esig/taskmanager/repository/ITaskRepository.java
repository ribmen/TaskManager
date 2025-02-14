package com.esig.taskmanager.repository;

import com.esig.taskmanager.model.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Integer> {

}
