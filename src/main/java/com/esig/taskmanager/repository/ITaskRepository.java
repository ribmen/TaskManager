package com.esig.taskmanager.repository;

import com.esig.taskmanager.model.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITaskRepository extends CrudRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE "
            + "(:title IS NULL OR LOWER(t.title) LIKE LOWER(CONCAT('%', :title, '%'))) "
            + "OR (:assignee IS NULL OR LOWER(t.assignee) LIKE LOWER(CONCAT('%', :assignee, '%'))) "
            + "OR (:pending IS NULL OR t.pending = :pending)")
    List<Task> findByFilters(@Param("title") String title,
                             @Param("assignee") String assignee,
                             @Param("pending") Boolean pending);
}
