package com.my.restapi.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
}
