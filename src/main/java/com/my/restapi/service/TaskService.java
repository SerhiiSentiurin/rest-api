package com.my.restapi.service;

import com.my.restapi.dao.TaskDao;
import com.my.restapi.dao.UserDao;
import com.my.restapi.dto.TaskDto;
import com.my.restapi.entity.Task;
import com.my.restapi.entity.User;
import com.my.restapi.exception.EntityNotFoundException;
import com.my.restapi.exception.UserAlreadyExistException;
import com.my.restapi.mapper.MapperTaskToTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDao taskDao;
    private final UserDao userDao;
    private final MapperTaskToTaskDto taskToTaskDto;

    public TaskDto crateTask(Task task, Long userId) {
        User user = userDao.findById(userId).orElseThrow(() -> new EntityNotFoundException("user with id " + userId + " not found"));
        List<Task> userTaskList = user.getTaskList();
        boolean isUserHaveTask = userTaskList.stream().anyMatch(userTask -> userTask.getTitle().equals(task.getTitle()));
        if (isUserHaveTask){
            throw new UserAlreadyExistException("user already have this task!");
        }
        task.setUser(user);
        Task savedTask = taskDao.save(task);
        return taskToTaskDto.map(savedTask);
    }

    public TaskDto completeTask(Long taskId) {
        Task task = taskDao.findById(taskId).orElseThrow(() -> new EntityNotFoundException("task with id " + taskId + " not found"));
        task.setCompleted(true);
        Task saveedTask = taskDao.save(task);
        return taskToTaskDto.map(saveedTask);
    }

    public TaskDto disCompleteTask(Long taskId) {
        Task task = taskDao.findById(taskId).orElseThrow(() -> new EntityNotFoundException("task with id " + taskId + " not found"));
        task.setCompleted(false);
        Task savedTask = taskDao.save(task);
        return taskToTaskDto.map(savedTask);
    }

}
