package com.my.restapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String login;
    private String firstName;
    private String lastname;
    private List<TaskDto> taskList;

}
