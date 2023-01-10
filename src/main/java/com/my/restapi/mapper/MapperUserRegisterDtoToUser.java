package com.my.restapi.mapper;

import com.my.restapi.dto.UserRegisterDto;
import com.my.restapi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MapperUserRegisterDtoToUser {
    public User map(UserRegisterDto userRegisterDto){
        User user = new User();
        user.setLogin(userRegisterDto.getLogin());
        user.setPassword(userRegisterDto.getPassword());
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        return user;
    }
}
