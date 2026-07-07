package com.example.login_project.repository;

import com.example.login_project.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);
    List<Task> findByUserIdAndStatus(Long userId, String status);//added on 6th order to use later

}

//THIRD STEP ORDER , here i added a task repository