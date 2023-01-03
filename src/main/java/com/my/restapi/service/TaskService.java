package com.my.restapi.service;

import com.my.restapi.dao.TaskDao;
import com.my.restapi.dao.UserDao;
import com.my.restapi.entity.Task;
import com.my.restapi.entity.User;
import com.my.restapi.exception.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDao taskDao;
    private final UserDao userDao;

    public Task crateTask(Task task, Long userId){
        checkUser(userId);
        return taskDao.save(task);
    }

    public Task completeTask(Long taskId){
        Task task = checkTask(taskId);
        task.setCompleted(true);
        return taskDao.save(task);
    }
    public Task disCompleteTask(Long taskId){
        Task task = checkTask(taskId);
        task.setCompleted(false);
        return taskDao.save(task);
    }

    private void checkUser(Long userId){
        Optional<User> userById = userDao.findById(userId);
        if (userById.isEmpty()){
            throw new AppException("cannot crate task for this user!");
        }
    }
    private Task checkTask(Long taskId){
        Optional<Task> taskById = taskDao.findById(taskId);
        if (taskById.isEmpty()){
            throw new AppException("task is not exist!");
        }
        return taskById.get();
    }

}
