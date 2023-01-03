package com.my.restapi.controller;

import com.my.restapi.entity.Task;
import com.my.restapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask (@RequestBody Task task,
                                           @RequestParam Long userId){
        try {
            return ResponseEntity.ok(taskService.crateTask(task,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/complete")
    public ResponseEntity<?> completeTask (@RequestParam Long taskId){
        try {
            return ResponseEntity.ok(taskService.completeTask(taskId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/discomplete")
    public ResponseEntity<?> disCompleteTask (@RequestParam Long taskId){
        try {
            return ResponseEntity.ok(taskService.disCompleteTask(taskId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
