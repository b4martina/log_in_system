package com.example.login_project.service;

//order 4 before controller
//
import com.example.login_project.model.Task;
import com.example.login_project.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);

    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getPendingTasks() {
        return taskRepository.findByStatus("PENDING");
    }

    public List<Task> getPendingTasksByUser(Long userId) {
        return taskRepository.findByUserIdAndStatus(userId, "PENDING"); //added after task repositoyry 7th order
    }


}
