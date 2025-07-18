package com.taskapp.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Task title (required)
    @Column(nullable = false, length = 100)
    private String title;

    // Optional description of the task
    @Column(length = 500)
    private String description;

    // Whether the task is completed or not
    private boolean completed = false;

    //Due date for the task
    private LocalDate dueDate;

    // Many tasks belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
