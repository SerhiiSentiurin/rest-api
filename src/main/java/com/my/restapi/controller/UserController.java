package com.my.restapi.controller;

import com.my.restapi.dto.UserDto;
import com.my.restapi.dto.UserRegisterDto;
import com.my.restapi.entity.User;
import com.my.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User registerUser(@RequestBody UserRegisterDto user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public UserDto getUsers(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public Long deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
