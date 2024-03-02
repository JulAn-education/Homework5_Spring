package ru.gb.Homework5_Spring.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDateTime dataTime;



}
