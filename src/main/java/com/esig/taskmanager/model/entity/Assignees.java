package com.esig.taskmanager.model.entity;

public enum Assignees {
    Victor,
    Carlos,
    David,
    Alberto,
    Roberta,
    Ivana,
    Iara,
    Alconaz;

    public static Assignees[] listAssignees() {
        return Assignees.values();
    }
};
