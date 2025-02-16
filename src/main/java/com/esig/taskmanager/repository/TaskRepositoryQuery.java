package com.esig.taskmanager.repository;

import com.esig.taskmanager.model.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Transactional
@Repository
public class TaskRepositoryQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> queryByFields(String title, String assign, Boolean pending) {
        var query = "SELECT t FROM Task t WHERE 1 = 1";
        if (title != null && !title.isBlank()) {
            query += " AND t.title LIKE :title";
        }
        if (assign != null && !assign.isBlank()) {
            query += " AND t.assign LIKE :assign";
        }
        if (pending != null) {
            query += " AND t.pending = :pending";
        }
        var createQuery = entityManager.createQuery(query, Task.class);
        if (title != null && !title.isBlank()) {
            createQuery.setParameter("title", "%" + title + "%");
        }
        if (assign != null && !assign.isBlank()) {
            createQuery.setParameter("assign", "%" + assign + "%");
        }
        if (pending != null) {
            createQuery.setParameter("pending", pending);
        }

        return createQuery.getResultList();
    }
}

