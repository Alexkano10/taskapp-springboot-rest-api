package com.taskapp.repository;

import com.taskapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Returns all tasks that belong to a given user ID
    List<Task> findByUserId(Long userId);
}
