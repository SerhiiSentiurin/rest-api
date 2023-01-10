package com.my.restapi.controller;

import com.my.restapi.dto.TaskDto;
import com.my.restapi.entity.Task;
import com.my.restapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskDto createTask(@RequestBody Task task,
                              @RequestParam Long userId) {
        return taskService.crateTask(task, userId);
    }

    @PutMapping("/complete")
    public TaskDto completeTask(@RequestParam Long taskId) {
        return taskService.completeTask(taskId);
    }

    @PutMapping("/discomplete")
    public TaskDto disCompleteTask(@RequestParam Long taskId) {
        return taskService.disCompleteTask(taskId);
    }
}
