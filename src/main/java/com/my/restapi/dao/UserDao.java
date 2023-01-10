package com.my.restapi.dao;

import com.my.restapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query("FROM users WHERE first_name = :firstName AND last_name = :lastName")
    Optional<User> findByFullName(@Param("firstName") String userFirstName,
                                  @Param("lastName") String userLastname);

}
