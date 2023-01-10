package com.my.restapi.dao;

import com.my.restapi.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskDao extends CrudRepository<Task, Long> {
    Optional<Task> findByTitleAndUserLogin(String title, String login);
}
