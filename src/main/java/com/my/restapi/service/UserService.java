package com.my.restapi.service;

import com.my.restapi.dao.UserDao;
import com.my.restapi.entity.User;
import com.my.restapi.exception.AppException;
import com.my.restapi.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public User registerUser(User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            throw new AppException("user with this login is already exist!");
        }
        return userDao.save(user);
    }

    public UserModel getUserById(Long id) {
        Optional<User> user = userDao.findById(id);;
        if (user.isEmpty()) {
            throw new AppException("user does not exist!");
        }
        return UserModel.toModel(user.get());
    }

    public Long deleteUserById(Long id) {
        if (userDao.findById(id).isEmpty()) {
            throw new AppException("user does not exist!");
        }
        userDao.deleteById(id);
        return id;
    }

}
