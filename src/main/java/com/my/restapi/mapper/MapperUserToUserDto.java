package com.my.restapi.mapper;

import com.my.restapi.dto.UserDto;
import com.my.restapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUserToUserDto {
    private final MapperTaskToTaskDto mapperTaskToTaskDto;
    public UserDto map (User user){
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastname(user.getLastName());
        userDto.setTaskList(mapperTaskToTaskDto.mapList(user.getTaskList()));
        return userDto;
    }
}
