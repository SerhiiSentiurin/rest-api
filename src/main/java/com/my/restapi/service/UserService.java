package com.my.restapi.service;

import com.my.restapi.dao.UserDao;
import com.my.restapi.dto.UserDto;
import com.my.restapi.dto.UserRegisterDto;
import com.my.restapi.entity.User;
import com.my.restapi.exception.EntityNotFoundException;
import com.my.restapi.mapper.MapperUserRegisterDtoToUser;
import com.my.restapi.mapper.MapperUserToUserDto;
import com.my.restapi.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final MapperUserToUserDto userToUserDto;
    private final MapperUserRegisterDtoToUser userRegisterDtoToUser;

    public User registerUser(UserRegisterDto userDto) {
        userValidator.validate(userDto);
        User user = userRegisterDtoToUser.map(userDto);
        return userDao.save(user);
    }

    public UserDto getUserById(Long id) {
        User user = userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("user " + id + " not found!"));
        return userToUserDto.map(user);
    }

    public Long deleteUserById(Long id) {
        userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("user with id " + id + " not found!"));
        userDao.deleteById(id);
        return id;
    }

}
