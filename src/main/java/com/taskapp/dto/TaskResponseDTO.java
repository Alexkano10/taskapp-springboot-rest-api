package com.taskapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO used to return task data to the client.
 */
@Getter
@Setter
@AllArgsConstructor
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
}
