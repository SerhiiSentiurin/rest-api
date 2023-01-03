package com.my.restapi.dao;

import com.my.restapi.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TaskDao extends CrudRepository<Task, Long> {
    Optional<Task> findById(Long id);
}
