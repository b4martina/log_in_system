package com.example.login_project.controllers;

// order 4 already, after repository and service
import com.example.login_project.model.Task;
import com.example.login_project.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

private final TaskService taskService;

public TaskController (TaskService taskService){
this.taskService=taskService;

}

@PostMapping
    public Task createTask (@RequestBody Task task){
    return taskService.saveTask(task);
}



@GetMapping
    public List<Task> getAllTasks(){
    return taskService.getAllTasks();
}

    @GetMapping("/pending")
    public List<Task> getPendingTasks(){
        return taskService.getPendingTasks();
    }

    @GetMapping("/all")
    public List<Task> getAllTasksForAdmin(){
    return taskService.getAllTasks();
    }


}
