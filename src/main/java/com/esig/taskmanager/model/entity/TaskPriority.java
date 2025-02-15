package com.esig.taskmanager.model.entity;

public enum TaskPriority {
    BAIXA,
    MÉDIA,
    ALTA;

    public static TaskPriority[] listPriorities() {
        return TaskPriority.values();
    }
};
