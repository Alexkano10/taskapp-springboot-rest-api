package com.taskapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO used to receive task creation or update data from the client.
 */
@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private boolean completed;

    private LocalDate dueDate;
}
