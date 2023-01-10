package com.my.restapi.mapper;

import com.my.restapi.dto.UserDto;
import com.my.restapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUserDtoToUser {
    private final MapperTaskDtoToTask mapperTaskDtoToTask;

    public User map(UserDto userDto){
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastname());
        user.setTaskList(mapperTaskDtoToTask.mapList(userDto.getTaskList()));
        return user;
    }
}
