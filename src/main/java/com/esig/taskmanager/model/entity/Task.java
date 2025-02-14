package com.esig.taskmanager.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "task")
public class Task implements Serializable {
    @Id
//    torna o id incrementável
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "priority")
    private TaskPriority priority;
    @Column(name = "date")
    private Date date;



}
