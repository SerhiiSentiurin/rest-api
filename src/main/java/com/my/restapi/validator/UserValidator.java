package com.my.restapi.validator;

import com.my.restapi.dao.UserDao;
import com.my.restapi.dto.UserRegisterDto;
import com.my.restapi.entity.User;
import com.my.restapi.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserDao userDao;

    public void validate(UserRegisterDto userDto) {
        Optional<User> foundUserByFullName = userDao.findByFullName(userDto.getFirstName(), userDto.getLastName());
        Optional<User> foundUserByLogin = userDao.findByLogin(userDto.getLogin());
        if (foundUserByLogin.isPresent()) {
            throw new UserAlreadyExistException("user wit this login is already exist!");
        }
        if (foundUserByFullName.isPresent()){
            throw new UserAlreadyExistException("user with this full name is already exist!");
        }
    }
}
